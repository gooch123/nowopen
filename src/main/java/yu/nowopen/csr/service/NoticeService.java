package yu.nowopen.csr.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yu.nowopen.csr.repository.NoticeRepository;
import yu.nowopen.csr.repository.StoreRepository;
import yu.nowopen.dto.NoticeInquiryRes;
import yu.nowopen.dto.NoticeSaveReq;
import yu.nowopen.dto.SliceResult;
import yu.nowopen.dto.UpdateNoticeReq;
import yu.nowopen.entity.Notice;
import yu.nowopen.exception.NotFoundNoticeException;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final StoreRepository storeRepository;

    public void saveNotice(NoticeSaveReq req) {
        Notice notice = new Notice(
                req.title(),
                req.body(),
                storeRepository.findById(req.storeId()).get()
        );
        noticeRepository.save(notice);
    }

    public void deleteNotice(Long noticeId) {
        noticeRepository.deleteById(noticeId);
    }

    @Transactional
    public void updateNotice(UpdateNoticeReq req) throws NotFoundNoticeException {
        Notice findNotice = noticeRepository.findById(req.noticeId()).orElseThrow(NotFoundNoticeException::new);
        findNotice.update(req.noticeTitle(),req.noticeBody());
        System.out.println("findNotice = " + findNotice);
    }

    public SliceResult<NoticeInquiryRes> getNoticeSlice(Long id, int page) {
        Slice<NoticeInquiryRes> result = noticeRepository.getNoticeSlice(id, PageRequest.of(page, 5));

        return new SliceResult<>(
                result.getContent(),
                result.hasNext()
        );
    }


}
