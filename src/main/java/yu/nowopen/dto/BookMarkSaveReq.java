package yu.nowopen.dto;

import yu.nowopen.entity.Member;
import yu.nowopen.entity.Store;

public record BookMarkSaveReq(
        String deviceId,
        Long storeId
) {
}
