package yu.nowopen.dto;

import com.querydsl.core.annotations.QueryProjection;

import java.time.LocalDateTime;

public record NoticeInquiryRes(
        Long id,
        String title,
        String body,
        LocalDateTime createTime,
        LocalDateTime lastModifiedTime
) {

    @QueryProjection
    public NoticeInquiryRes(Long id, String title, String body, LocalDateTime createTime, LocalDateTime lastModifiedTime) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createTime = createTime;
        this.lastModifiedTime = lastModifiedTime;
    }
}
