package yu.nowopen.csr.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yu.nowopen.csr.repository.MemberRepository;
import yu.nowopen.dto.MemberSaveReq;
import yu.nowopen.entity.Member;
import yu.nowopen.exception.DuplicateMemberIdException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void saveMember(MemberSaveReq memberSaveReq) {
        if (memberRepository.existsMemberByUsername(memberSaveReq.id())) {
            throw new DuplicateMemberIdException();
        }else {
            Member member = memberSaveReq.toEntity();
            memberRepository.save(member);
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
