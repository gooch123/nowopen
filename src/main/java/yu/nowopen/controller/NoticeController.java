package yu.nowopen.controller;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import yu.nowopen.repository.NoticeRepository;
import yu.nowopen.service.NoticeService;
import yu.nowopen.dto.NoticeInquiryRes;
import yu.nowopen.dto.NoticeSaveReq;
import yu.nowopen.dto.SliceResult;
import yu.nowopen.dto.UpdateNoticeReq;
import yu.nowopen.exception.NotFoundNoticeException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
@Slf4j
public class NoticeController {

    private final NoticeService noticeService;

    @PostMapping("/save")
    public void save(@RequestBody NoticeSaveReq req) {
        noticeService.saveNotice(req);
    }

    @PostMapping("/update")
    public UpdateRes update(@RequestBody UpdateNoticeReq req) {

        UpdateRes updateRes = new UpdateRes();

        try {
            noticeService.updateNotice(req);
            updateRes.setIsValidNotice(true);
            updateRes.setNoticeId(req.noticeId());
        } catch (NotFoundNoticeException e) {
            updateRes.setIsValidNotice(false);
            updateRes.setException(e);
        }

        return updateRes;
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        noticeService.deleteNotice(id);
    }


    @GetMapping("/{id}")
    public SliceResult<NoticeInquiryRes> getNotice(@PathVariable Long id, @RequestParam int page){
        log.info("hasNext = {}", noticeService.getNoticeSlice(id,page).hasNext());
        return noticeService.getNoticeSlice(id, page);
    }

    @Setter
    @Getter
    static class UpdateRes{

        private Exception exception;
        private Boolean isValidNotice;
        private Long noticeId;

    }



}
