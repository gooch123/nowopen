package yu.nowopen.csr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yu.nowopen.entity.Notice;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice,Long>, NoticeRepositoryCustom {


}
