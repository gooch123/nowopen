package yu.nowopen.csr.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yu.nowopen.csr.repository.MemberRepository;
import yu.nowopen.csr.repository.StoreRepository;
import yu.nowopen.dto.*;
import yu.nowopen.entity.Member;
import yu.nowopen.entity.Store;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    public Store save(CreateStoreReq req, Member owner) {
        Store store = new Store(
                req.name(),
                req.openTime(),
                req.closeTime(),
                owner
        );

        return storeRepository.save(store);
    }

    public void delete(Long storeId) {
        storeRepository.deleteById(storeId);
    }

    @Transactional
    public SliceResult<StoreSearchRes> search(Pageable pageable, StoreSearchCondition cond) {
         Slice<Store> stores = storeRepository.findAllByStoreNameContains(cond.storeName(), pageable);
        ArrayList<StoreSearchRes> storeSearchRes = new ArrayList<>();
        for (Store value : stores.getContent()) {
            storeSearchRes.add(new StoreSearchRes(
                    value.getId(),
                    value.getStoreName(),
                    value.getOpenTime(),
                    value.getCloseTime()
            ));
        }
        return new SliceResult<>(
                storeSearchRes,
                stores.hasNext()
        );
    }

    public Store getStore(Long id) {
        return storeRepository.findById(id).orElseThrow();
    }

    public Store getStore(Member member) {
        return storeRepository.findByOwner(member).orElse(null);
    }


    @Transactional
    public void updateStore(Long id,String name, LocalTime openTIme, LocalTime closeTime) {

        Store store = storeRepository.findById(id).orElseThrow();
        store.update(name,openTIme,closeTime);

    }
}
