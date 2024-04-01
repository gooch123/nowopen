package yu.nowopen.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import yu.nowopen.enumrate.StoreStatus;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    Long id;
    String storeName;
    LocalDateTime openTime;
    LocalDateTime closeTime;

    @OneToOne
    @JoinColumn(name = "member_id")
    Member owner;

    public Store(String storeName, LocalDateTime openTime, LocalDateTime closeTime, Member owner) {
        this.storeName = storeName;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.owner = owner;
    }
}
