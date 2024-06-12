package yu.nowopen.testdata;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cglib.core.Local;
import org.springframework.context.event.EventListener;
import yu.nowopen.repository.MemberRepository;
import yu.nowopen.repository.NoticeRepository;
import yu.nowopen.repository.StoreRepository;
import yu.nowopen.entity.Member;
import yu.nowopen.entity.Notice;
import yu.nowopen.entity.Store;

import java.time.LocalTime;

@RequiredArgsConstructor

public class TestInit {

    private final MemberRepository memberRepository;
    private final NoticeRepository noticeRepository;
    private final StoreRepository storeRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {

        Member member = new Member(
                "gooch123",
                "goo6485"
        );
        memberRepository.save(member);

        Member member2 = new Member(
                "test",
                "0000"
        );
        memberRepository.save(member2);

        Member member3 = new Member(
                "test2",
                "0000"
        );
        memberRepository.save(member3);

        Store store = new Store(
                "영남대 가게",
                LocalTime.of(9,0),
                LocalTime.of(23,0),
                member
        );
        storeRepository.save(store);

        noticeRepository.save(Notice.builder()
                .title("정상영업")
                .body("우리 가게 정상 영업 합니다")
                .store(store)
                .build());
        noticeRepository.save(Notice.builder()
                .title("정상영업1")
                .body("우리 가게 정상 영업 합니다1")
                .store(store)
                .build());
        noticeRepository.save(Notice.builder()
                .title("정상영업2")
                .body("우리 가게 정상 영업 합니다2")
                .store(store)
                .build());
        noticeRepository.save(Notice.builder()
                .title("정상영업3")
                .body("우리 가게 정상 영업 합니다3")
                .store(store)
                .build());
        noticeRepository.save(Notice.builder()
                .title("정상영업4")
                .body("우리 가게 정상 영업 합니다4")
                .store(store)
                .build());
        noticeRepository.save(Notice.builder()
                .title("정상영업5")
                .body("우리 가게 정상 영업 합니다5")
                .store(store)
                .build());
        noticeRepository.save(Notice.builder()
                .title("정상영업6")
                .body("우리 가게 정상 영업 합니다6")
                .store(store)
                .build());
        noticeRepository.save(Notice.builder()
                .title("정상영업7")
                .body("우리 가게 정상 영업 합니다7")
                .store(store)
                .build());
    }

}
