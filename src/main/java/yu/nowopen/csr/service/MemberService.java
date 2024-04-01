package yu.nowopen.csr.service;

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

    public void saveMember(MemberSaveReq memberSaveReq) throws DuplicateMemberIdException {
        if (memberRepository.existsMemberByUseId(memberSaveReq.id())) {
            throw new DuplicateMemberIdException();
        }else {
            Member member = memberSaveReq.toEntity();
            memberRepository.save(member);
        }
    }

}
