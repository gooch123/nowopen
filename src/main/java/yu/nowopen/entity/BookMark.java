package yu.nowopen.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class BookMark {

    @Id @GeneratedValue
    Long id;
    @ManyToOne
    Member member;
    @ManyToOne
    Store store;

}
