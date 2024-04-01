package yu.nowopen.testdata;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import yu.nowopen.csr.repository.MemberRepository;
import yu.nowopen.csr.repository.NoticeRepository;
import yu.nowopen.csr.repository.StoreRepository;
import yu.nowopen.entity.Member;
import yu.nowopen.entity.Notice;
import yu.nowopen.entity.Store;
import yu.nowopen.enumrate.MemberType;

import java.time.LocalDateTime;

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
                , MemberType.OWNER
        );
        memberRepository.save(member);

        Store store = new Store(
                "영남대 가게",
                LocalDateTime.now(),
                LocalDateTime.now(),
                member
        );
        storeRepository.save(store);

        noticeRepository.save(Notice.builder()
                .title("정상영업")
                .time(LocalDateTime.of(2024,01,23,10,10))
                .body("우리 가게 정상 영업 합니다")
                .store(store)
                .build());
        noticeRepository.save(Notice.builder()
                .title("정상영업1")
                .time(LocalDateTime.of(2024,01,24,10,10))
                .body("우리 가게 정상 영업 합니다1")
                .store(store)
                .build());
        noticeRepository.save(Notice.builder()
                .title("정상영업2")
                .time(LocalDateTime.of(2024,01,25,10,10))
                .body("우리 가게 정상 영업 합니다2")
                .store(store)
                .build());
        noticeRepository.save(Notice.builder()
                .title("정상영업3")
                .time(LocalDateTime.of(2024,01,25,10,12))
                .body("우리 가게 정상 영업 합니다3")
                .store(store)
                .build());
        noticeRepository.save(Notice.builder()
                .title("정상영업4")
                .time(LocalDateTime.of(2024,01,25,10,1))
                .body("우리 가게 정상 영업 합니다4")
                .store(store)
                .build());
        noticeRepository.save(Notice.builder()
                .title("정상영업5")
                .time(LocalDateTime.of(2024,01,26,10,10))
                .body("우리 가게 정상 영업 합니다5")
                .store(store)
                .build());
        noticeRepository.save(Notice.builder()
                .title("정상영업6")
                .time(LocalDateTime.of(2024,01,27,10,10))
                .body("우리 가게 정상 영업 합니다6")
                .store(store)
                .build());
        noticeRepository.save(Notice.builder()
                .title("정상영업7")
                .time(LocalDateTime.of(2024,01,28,10,10))
                .body("우리 가게 정상 영업 합니다7")
                .store(store)
                .build());
    }

}
