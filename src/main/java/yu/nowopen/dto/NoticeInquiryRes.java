package yu.nowopen.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public record NoticeInquiryRes(
        String title,
        String body,
        LocalDateTime createTime,
        LocalDateTime LastModifiedTime
) {

    @QueryProjection
    public NoticeInquiryRes(String title, String body, LocalDateTime createTime, LocalDateTime LastModifiedTime) {
        this.title = title;
        this.body = body;
        this.createTime = createTime;
        this.LastModifiedTime = LastModifiedTime;
    }
}
