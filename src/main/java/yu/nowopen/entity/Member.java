package yu.nowopen.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import yu.nowopen.enumrate.MemberType;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    Long id;
    String useId;
    String pwd;
    @Enumerated(EnumType.STRING)
    MemberType type;

    @Builder
    public Member(String useId, String pwd, MemberType type) {
        this.useId = useId;
        this.pwd = pwd;
        this.type = type;
    }
}
