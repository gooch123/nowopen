package yu.nowopen.dto;

import yu.nowopen.entity.Store;

import java.time.LocalDateTime;

public record NoticeSaveReq(
        LocalDateTime time,
        String title,
        String body,
        Long storeId
) {
}
