package yu.nowopen.csr.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yu.nowopen.csr.repository.MemberRepository;
import yu.nowopen.dto.MemberSaveReq;
import yu.nowopen.entity.Member;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void saveMember(MemberSaveReq memberSaveReq) {
        Member member = memberSaveReq.toEntity();
        memberRepository.save(member);
    }

}
