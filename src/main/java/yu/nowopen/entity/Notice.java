package yu.nowopen.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Notice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    LocalDateTime time;
    String title;
    String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    Store store;

    @Builder
    public Notice(LocalDateTime time, String title, String body, Store store) {
        this.time = time;
        this.title = title;
        this.body = body;
        this.store = store;
    }

    public void update(String title, String body, LocalDateTime updateTime) {
        this.title = title;
        this.body = body;
        this.time = updateTime;
    }

}
