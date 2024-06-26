package yu.nowopen;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import yu.nowopen.repository.MemberRepository;
import yu.nowopen.repository.NoticeRepository;
import yu.nowopen.repository.StoreRepository;
import yu.nowopen.testdata.TestInit;

@SpringBootApplication
@EnableJpaAuditing
public class NowopenApplication {

	public static void main(String[] args) {
		SpringApplication.run(NowopenApplication.class, args);
	}

	@Bean
	JPAQueryFactory jpaQueryFactory(EntityManager em){
		return new JPAQueryFactory(em);
	}

	@Bean
	TestInit testInit(NoticeRepository noticeRepository, MemberRepository memberRepository, StoreRepository storeRepository) {
		return new TestInit(memberRepository,noticeRepository,storeRepository);
	}

}
