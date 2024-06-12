package yu.nowopen.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yu.nowopen.dto.*;
import yu.nowopen.entity.BookMark;
import yu.nowopen.service.BookMarkService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/bookmark")
public class BookmarkController {

    private final BookMarkService bookMarkService;

    @PostMapping("/save")
    public ResponseEntity<?> saveBookmark(@RequestBody BookMarkSaveReq req) {
        log.info("deviceId = {}",req.deviceId());
        BookMark save = bookMarkService.save(req);
        return new ResponseEntity<>(new CreatedRes(save.getId()), HttpStatus.OK);
    }

    @PostMapping("/{id}/delete/{deviceId}")
    public ResponseEntity<?> deleteBookmark(@PathVariable Long id, @PathVariable String deviceId){

        log.info("delete OK");
        bookMarkService.cancel(id,deviceId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public SliceResult<StoreRes> getMyBookmark(@RequestParam String deviceId, @RequestParam int page){

        return bookMarkService.getMyBookmarks(deviceId, page);
    }

}
