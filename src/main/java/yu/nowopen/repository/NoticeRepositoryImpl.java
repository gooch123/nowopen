package yu.nowopen.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import yu.nowopen.dto.NoticeInquiryRes;
import yu.nowopen.dto.QNoticeInquiryRes;

import java.util.List;

import static yu.nowopen.entity.QNotice.*;
import static yu.nowopen.entity.QStore.*;

@RequiredArgsConstructor
public class NoticeRepositoryImpl implements NoticeRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public Slice<NoticeInquiryRes> getNoticeSlice(Long findStore, Pageable pageable) {
        int pageSize = pageable.getPageSize();

        List<NoticeInquiryRes> content = queryFactory
                .select(new QNoticeInquiryRes(
                        notice.id,
                        notice.title,
                        notice.body,
                        notice.createTime,
                        notice.lastModifiedTime
                ))
                .from(notice)
                .leftJoin(notice.store ,store)
                .where(store.id.eq(findStore))
                .offset(pageable.getOffset())
                .limit(pageSize + 1)
                .fetch();

        boolean hasNext = false;
        if (content.size() > pageSize) {
            content.remove(pageSize);
            hasNext = true;
        }

        return new SliceImpl<>(content,pageable,hasNext);
    }
}
