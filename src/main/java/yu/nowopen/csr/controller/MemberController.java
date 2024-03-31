package yu.nowopen.csr.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yu.nowopen.csr.service.MemberService;
import yu.nowopen.dto.MemberSaveReq;
import yu.nowopen.entity.Notice;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public MemberSaveReq join(@RequestBody MemberSaveReq memberSaveReq) {
        return memberSaveReq;
    }

}
