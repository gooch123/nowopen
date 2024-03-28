package yu.nowopen.dto;

public record UpdateNoticeReq(
        Long noticeId,
        String noticeTitle,
        String noticeBody
) {
}
