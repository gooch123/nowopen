package yu.nowopen.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import yu.nowopen.enumrate.StoreStatus;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store extends TimeBase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    Long id;
    String storeName;
    @DateTimeFormat(pattern = "'T'HH:mm")
    LocalTime openTime;
    @DateTimeFormat(pattern = "'T'HH:mm")
    LocalTime closeTime;

    @OneToOne
    @JoinColumn(name = "member_id")
    Member owner;

    public Store(String storeName, LocalTime openTime, LocalTime closeTime, Member owner) {
        this.storeName = storeName;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.owner = owner;
    }

    public void update(String name, LocalTime openTime, LocalTime closeTime) {
        this.storeName = name;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

}
