package yu.nowopen.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice {

    @Id @GeneratedValue
    @Column(name = "notice_id")
    Long id;
    LocalDateTime time;
    String title;
    String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    Store store;

    public Notice(LocalDateTime time, String title, String body, Store store) {
        this.time = time;
        this.title = title;
        this.body = body;
        this.store = store;
    }

    public void update(String title, String body, LocalDateTime updateTime) {
        this.title = title;
        this.body = body;
        this.time = time;
    }

}
