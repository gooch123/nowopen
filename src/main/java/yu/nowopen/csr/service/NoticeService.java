package yu.nowopen.csr.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yu.nowopen.csr.repository.NoticeRepository;
import yu.nowopen.dto.NoticeSaveReq;
import yu.nowopen.dto.UpdateNoticeReq;
import yu.nowopen.entity.Notice;
import yu.nowopen.exception.NotFoundRecordException;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public void saveNotice(NoticeSaveReq req) {
        Notice notice = new Notice(
                req.time(),
                req.title(),
                req.body(),
                req.store()
        );

        noticeRepository.save(notice);
    }

    public void deleteNotice(Long noticeId) {
        noticeRepository.deleteById(noticeId);
    }

    public void updateNotice(UpdateNoticeReq req) {
        Notice findNotice = noticeRepository.findById(req.noticeId()).orElseThrow(NotFoundRecordException::new);
        findNotice.update(req.noticeTitle(),req.noticeBody(), LocalDateTime.now());
    }


}
