package yu.nowopen.dto;

import lombok.Builder;
import yu.nowopen.entity.Member;
import yu.nowopen.enumrate.MemberType;

public record MemberSaveReq(
        String username,
        String password
) {

    @Builder
    public MemberSaveReq(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Member toEntity() {
        return Member.builder()
                .username(username())
                .password(password())
                .build();
    }
}
