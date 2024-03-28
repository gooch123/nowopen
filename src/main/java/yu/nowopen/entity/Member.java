package yu.nowopen.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import yu.nowopen.enumrate.MemberType;

@Entity
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    Long id;
    String memberId;
    String pwd;
    @Enumerated(EnumType.STRING)
    MemberType type;

    @Builder
    public Member(String memberId, String pwd, MemberType type) {
        this.memberId = memberId;
        this.pwd = pwd;
        this.type = type;
    }
}
