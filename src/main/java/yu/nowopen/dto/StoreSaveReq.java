package yu.nowopen.dto;

import yu.nowopen.entity.Member;
import yu.nowopen.enumrate.StoreStatus;

public record StoreSaveReq(

        String storeName,
        String openTime,
        String closeTime,
        Member owner
) {

}
