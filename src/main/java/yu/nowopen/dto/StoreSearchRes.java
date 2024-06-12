package yu.nowopen.dto;

import com.querydsl.core.annotations.QueryProjection;
import yu.nowopen.enumrate.StoreStatus;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record StoreSearchRes(
        Long id,
        String storeName,
        LocalTime openTime,
        LocalTime closeTime,
        boolean isBookmarked
) {

}
