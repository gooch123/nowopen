package yu.nowopen.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yu.nowopen.repository.MemberRepository;
import yu.nowopen.dto.MemberSaveReq;
import yu.nowopen.entity.Member;
import yu.nowopen.exception.DuplicateMemberIdException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveMember(MemberSaveReq memberSaveReq) {
        if (memberRepository.existsMemberByUsername(memberSaveReq.username())) {
            throw new DuplicateMemberIdException();
        }else {
            Member member = memberSaveReq.toEntity();
            return memberRepository.save(member);
        }
    }

    public String login(String username, String password, HttpSession session) {
        Member member = memberRepository.findByUsername(username);
        if (member != null && member.getPassword().equals(password)) {
            session.setAttribute("member", member);
            return session.getId();
        }
        return "Invalid credentials";
    }

    public boolean isAuthenticated(HttpSession session) {
        return session.getAttribute("member") != null;
    }

    public Member getAuthentication(HttpSession session) {
        return (Member) session.getAttribute("member");
    }

}
