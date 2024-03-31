package yu.nowopen.csr.controller;


import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;
import yu.nowopen.csr.service.NoticeService;
import yu.nowopen.dto.NoticeSaveReq;
import yu.nowopen.dto.UpdateNoticeReq;
import yu.nowopen.exception.NotFoundRecordException;

import java.awt.print.Pageable;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @PostMapping("/notice/save")
    public void save(@RequestBody NoticeSaveReq req) {
        noticeService.saveNotice(req);
    }

    @PostMapping("/notice/update")
    public UpdateRes update(@RequestBody UpdateNoticeReq req) {

        UpdateRes updateRes = new UpdateRes();

        try {
            noticeService.updateNotice(req);
            updateRes.setIsValidNotice(true);
            updateRes.setNoticeId(req.noticeId());
        } catch (NotFoundRecordException e) {
            updateRes.setIsValidNotice(false);
            updateRes.setException(e);
        }

        return updateRes;
    }

    @GetMapping("/notice")
    public void getNotice(@RequestParam Long storeId, Pageable pageable){

    }

    @Setter
    static class UpdateRes{

        private Exception exception;
        private Boolean isValidNotice;
        private Long noticeId;

    }



}
