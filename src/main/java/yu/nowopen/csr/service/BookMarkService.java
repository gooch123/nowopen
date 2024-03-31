package yu.nowopen.csr.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yu.nowopen.csr.repository.BookMarkRepository;
import yu.nowopen.dto.BookMarkSaveReq;
import yu.nowopen.entity.BookMark;

@Service
@RequiredArgsConstructor
public class BookMarkService {

    private final BookMarkRepository bookMarkRepository;

    public void save(BookMarkSaveReq req) {
        BookMark bookMark = new BookMark(req.member(), req.store());
        bookMarkRepository.save(bookMark);
    }

    public void cancel(Long bookMarkId) {
        bookMarkRepository.deleteById(bookMarkId);
    }

}
