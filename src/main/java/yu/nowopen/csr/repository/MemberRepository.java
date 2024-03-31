package yu.nowopen.csr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yu.nowopen.entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Boolean existsMemberByMemberId(String memberId);
}
