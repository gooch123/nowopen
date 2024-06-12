package yu.nowopen.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import yu.nowopen.dto.SliceResult;
import yu.nowopen.entity.BookMark;
import yu.nowopen.entity.Store;

public interface BookMarkRepository extends JpaRepository<BookMark,Long> {

    Slice<BookMark> findAllByDeviceId(String deviceId, Pageable pageable);

    boolean existsByStoreAndDeviceId(Store store, String deviceId);

    void deleteByStoreIdAndDeviceId(Long store, String deviceId);

}
