package yu.nowopen.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record CreateStoreReq(
        String name,
        LocalTime openTime,
        LocalTime closeTime
) {
}
