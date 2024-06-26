package yu.nowopen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yu.nowopen.entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Boolean existsMemberByUsername(String username);

    Member findByUsername(String username);
}
