package yu.nowopen.csr.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import yu.nowopen.dto.NoticeInquiryRes;
import yu.nowopen.entity.Store;

public interface NoticeRepositoryCustom {

    Slice<NoticeInquiryRes> getNoticeSlice(Long storeId, Pageable pageable);

}
