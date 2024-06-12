package yu.nowopen.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yu.nowopen.repository.BookMarkRepository;
import yu.nowopen.repository.MemberRepository;
import yu.nowopen.repository.StoreRepository;
import yu.nowopen.dto.*;
import yu.nowopen.entity.Member;
import yu.nowopen.entity.Store;

import java.time.LocalTime;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final BookMarkRepository bookMarkRepository;

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
    public SliceResult<StoreSearchRes> search(Pageable pageable, StoreSearchCondition cond, String deviceId) {
         Slice<Store> stores = storeRepository.findAllByStoreNameContains(cond.storeName(), pageable);
        ArrayList<StoreSearchRes> storeSearchRes = new ArrayList<>();
        for (Store value : stores.getContent()) {
            storeSearchRes.add(new StoreSearchRes(
                    value.getId(),
                    value.getStoreName(),
                    value.getOpenTime(),
                    value.getCloseTime(),
                    bookMarkRepository.existsByStoreAndDeviceId(value, deviceId)
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
