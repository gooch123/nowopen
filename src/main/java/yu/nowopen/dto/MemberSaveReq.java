package yu.nowopen.dto;

import lombok.Builder;
import yu.nowopen.entity.Member;
import yu.nowopen.enumrate.MemberType;

public record MemberSaveReq(
        String id,
        String pwd,
        MemberType memberType
) {

    @Builder
    public MemberSaveReq(String id, String pwd, MemberType memberType) {
        this.id = id;
        this.pwd = pwd;
        this.memberType = memberType;
    }

    public Member toEntity() {
        return Member.builder()
                .useId(id())
                .pwd(pwd())
                .type(memberType())
                .build();
    }
}
