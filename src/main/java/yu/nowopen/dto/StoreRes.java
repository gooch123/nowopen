package yu.nowopen.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record StoreRes(
        Long id,
        String storeName,
        LocalTime openTime,
        LocalTime closeTime
) {
}
