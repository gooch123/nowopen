package yu.nowopen.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yu.nowopen.dto.SliceResult;
import yu.nowopen.dto.StoreRes;
import yu.nowopen.entity.Store;
import yu.nowopen.repository.BookMarkRepository;
import yu.nowopen.dto.BookMarkSaveReq;
import yu.nowopen.entity.BookMark;
import yu.nowopen.repository.StoreRepository;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class BookMarkService {

    private final BookMarkRepository bookMarkRepository;
    private final StoreRepository storeRepository;

    public BookMark save(BookMarkSaveReq req) {
        BookMark bookMark = new BookMark(req.deviceId(), storeRepository.findById(req.storeId()).orElseThrow());
        return bookMarkRepository.save(bookMark);
    }

    @Transactional
    public void cancel(Long storeId , String deviceId) {
        bookMarkRepository.deleteByStoreIdAndDeviceId(storeId,deviceId);
    }

    @Transactional
    public SliceResult<StoreRes> getMyBookmarks(String deviceId, int page) {

        Slice<BookMark> result = bookMarkRepository.findAllByDeviceId(deviceId, PageRequest.of(page, 10));

        ArrayList<StoreRes> storeRes = new ArrayList<>();

        for (BookMark bookMark : result.getContent()) {
            Store store = bookMark.getStore();
            storeRes.add(new StoreRes(
                    store.getId(),
                    store.getStoreName(),
                    store.getOpenTime(),
                    store.getCloseTime()
            ));
        }

        return new SliceResult<>(
                storeRes,
                result.hasNext()
        );

    }

}
