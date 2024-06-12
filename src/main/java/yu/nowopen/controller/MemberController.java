package yu.nowopen.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yu.nowopen.service.MemberService;
import yu.nowopen.dto.*;
import yu.nowopen.entity.Member;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody MemberSaveReq memberSaveReq) {
        Member member = memberService.saveMember(memberSaveReq);
        return new ResponseEntity<>(new CreatedRes(member.getId()), HttpStatus.OK);
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
