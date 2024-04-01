package yu.nowopen.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NoticeInquiryRes {

    private String title;
    private String body;
    private LocalDateTime time;

    @QueryProjection
    public NoticeInquiryRes(String title, String body, LocalDateTime time) {
        this.title = title;
        this.body = body;
        this.time = time;
    }
}
