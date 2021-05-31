package com.summer.dev.domain.wedding;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class WeddingCardController {

    @PostMapping("/wedding_card/record")
    public void record(@RequestBody RecordRequest request) {
        log.info("record : " + request);
    }
}
