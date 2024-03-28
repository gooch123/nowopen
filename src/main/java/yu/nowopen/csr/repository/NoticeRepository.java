package yu.nowopen.csr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yu.nowopen.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice,Long> {


}
