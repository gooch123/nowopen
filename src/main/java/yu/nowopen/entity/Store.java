package yu.nowopen.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import yu.nowopen.enumrate.StoreStatus;

@Entity
@NoArgsConstructor
public class Store {

    @Id @GeneratedValue
    Long id;
    String storeName;
    String openTime;
    String closeTime;
    @Enumerated
    StoreStatus storeStatus;

    public Store(String storeName, String openTime, String closeTime, StoreStatus storeStatus) {
        this.storeName = storeName;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.storeStatus = storeStatus;
    }
}
