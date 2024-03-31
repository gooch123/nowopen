package yu.nowopen.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import yu.nowopen.enumrate.MemberType;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
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
