package yu.nowopen.dto;

import java.time.LocalTime;

public record StoreUpdateReq(
        Long id,
        String name,
        LocalTime openTime,
        LocalTime closeTime
) {
}
