package yu.nowopen.csr.repository;

import org.springframework.data.domain.Slice;
import yu.nowopen.dto.NoticeInquiryRes;

public interface NoticeRepositoryCustom {

    Slice<NoticeInquiryRes> getNoticeSlice();

}
