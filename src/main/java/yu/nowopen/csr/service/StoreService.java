package yu.nowopen.csr.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yu.nowopen.csr.repository.StoreRepository;
import yu.nowopen.dto.StoreSaveReq;
import yu.nowopen.entity.Store;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public void save(StoreSaveReq req) {
        Store store = new Store(
                req.storeName(),
                req.openTime(),
                req.closeTime(),
                req.owner()
        );

        storeRepository.save(store);
    }

    public void delete(Long storeId) {
        storeRepository.deleteById(storeId);
    }

}
