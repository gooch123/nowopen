package yu.nowopen.csr.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yu.nowopen.csr.service.MemberService;
import yu.nowopen.dto.*;
import yu.nowopen.entity.Member;
import yu.nowopen.entity.Notice;
import yu.nowopen.exception.DuplicateMemberIdException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public MemberSaveRes join(@RequestBody MemberSaveReq memberSaveReq) {
        memberService.saveMember(memberSaveReq);
        return new MemberSaveRes("회원가입 성공");
    }

    @PostMapping("/login")
    public String login(
            @RequestBody LoginForm form,
            HttpSession session){
        String sessionId = memberService.login(form.username(), form.password(), session);
        if (sessionId != null) {
            return sessionId;
        }
        return "Invalid credentials";
    }
    
    @PostMapping("/test")
    public String test(HttpSession httpSession){

        Member member = memberService.getAuthentication(httpSession);
        log.info("username = {}",member.getUsername());

        if (member == null) {
            return "Unauthorized";
        }

        return "welcome";
    }



}
