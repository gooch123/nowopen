package yu.nowopen.csr.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yu.nowopen.csr.repository.MemberRepository;
import yu.nowopen.csr.repository.StoreRepository;
import yu.nowopen.dto.StoreSaveReq;
import yu.nowopen.entity.Store;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    public void save(StoreSaveReq req) {
        Store store = new Store(
                req.storeName(),
                req.openTime(),
                req.closeTime(),
                memberRepository.findById(req.memberId()).get()
        );

        storeRepository.save(store);
    }

    public void delete(Long storeId) {
        storeRepository.deleteById(storeId);
    }

}
