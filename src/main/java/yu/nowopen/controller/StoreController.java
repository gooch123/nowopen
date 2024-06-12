package yu.nowopen.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yu.nowopen.service.MemberService;
import yu.nowopen.service.StoreService;
import yu.nowopen.dto.CreateStoreReq;
import yu.nowopen.dto.CreatedRes;
import yu.nowopen.dto.StoreRes;
import yu.nowopen.dto.StoreUpdateReq;
import yu.nowopen.entity.Member;
import yu.nowopen.entity.Store;
import yu.nowopen.exception.UnAuthorizedMemberException;

@Slf4j
@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;
    private final MemberService memberService;

    @GetMapping("/{id}")
    public StoreRes getStore(@PathVariable Long id){

        Store store = storeService.getStore(id);

        return new StoreRes(
                store.getId(),
                store.getStoreName(),
                store.getOpenTime(),
                store.getCloseTime()
        );
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateStore(@RequestBody StoreUpdateReq req){

        storeService.updateStore(req.id(), req.name(), req.openTime(), req.closeTime());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStore(
            @RequestBody CreateStoreReq req,
            HttpSession session){

        Member member = memberService.getAuthentication(session);
        if (member == null) {
            throw new UnAuthorizedMemberException("회원만 사용가능합니다");
        }

        log.info("req = {}",req);
        Store saveStore = storeService.save(req, member);

        return new ResponseEntity<>(new CreatedRes(saveStore.getId()), HttpStatus.OK);
    }

    @GetMapping("/my")
    public ResponseEntity<?> getMyStore(HttpSession session){

        Member member = memberService.getAuthentication(session);
        if (member == null) {
            throw new UnAuthorizedMemberException("회원만 사용가능합니다");
        }
        log.info("member.username = {}",member.getUsername());

        Store store = storeService.getStore(member);
        if (store == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new StoreRes(
                store.getId(),
                store.getStoreName(),
                store.getOpenTime(),
                store.getCloseTime()
        ),HttpStatus.OK);
    }


}
