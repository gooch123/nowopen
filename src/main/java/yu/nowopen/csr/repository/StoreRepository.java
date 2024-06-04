package yu.nowopen.csr.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import yu.nowopen.entity.Member;
import yu.nowopen.entity.Store;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store,Long> {

    Slice<Store> findAllByStoreNameContains(String storeName, Pageable pageable);

    Optional<Store> findByOwner(Member owner);

}
