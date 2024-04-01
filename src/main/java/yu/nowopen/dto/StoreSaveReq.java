package yu.nowopen.dto;

import yu.nowopen.entity.Member;
import yu.nowopen.enumrate.StoreStatus;

import java.time.LocalDateTime;

public record StoreSaveReq(

        String storeName,
        LocalDateTime openTime,
        LocalDateTime closeTime,
        Member owner
) {

}
