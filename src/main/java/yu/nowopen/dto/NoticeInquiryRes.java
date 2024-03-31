package yu.nowopen.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class NoticeInquiryRes {

    private String title;
    private String body;
    private LocalDateTime time;

}
