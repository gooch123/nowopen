package yu.nowopen.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import yu.nowopen.enumrate.StoreStatus;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {

    @Id @GeneratedValue
    @Column(name = "store_id")
    Long id;
    String storeName;
    String openTime;
    String closeTime;

    @OneToOne
    @JoinColumn(name = "member_id")
    Member owner;

    public Store(String storeName, String openTime, String closeTime, Member owner) {
        this.storeName = storeName;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.owner = owner;
    }
}
