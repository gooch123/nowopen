package yu.nowopen.csr.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yu.nowopen.csr.service.StoreService;
import yu.nowopen.dto.SliceResult;
import yu.nowopen.dto.StoreRes;
import yu.nowopen.dto.StoreSearchCondition;
import yu.nowopen.dto.StoreSearchRes;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SearchController {

    private final StoreService storeService;

    @GetMapping("/search")
    public SliceResult<StoreSearchRes> getSearchStores(
            @RequestParam String storeName,
            @RequestParam int page
    ) {
        log.info("search = {}",storeName);
        return storeService.search(PageRequest.of(page, 10), new StoreSearchCondition(storeName));
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        log.info("test ok");
        return new ResponseEntity<>("test OK", HttpStatus.OK);
    }



}
