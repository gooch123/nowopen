package yu.nowopen.dto;

import yu.nowopen.entity.Store;

import java.time.LocalDateTime;

public record NoticeSaveReq(
        String title,
        String body,
        Long storeId
) {
}
