package yu.nowopen.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
public class Notice {

    @Id @GeneratedValue
    Long id;
    LocalDateTime time;
    String title;
    String body;
    @ManyToOne
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
