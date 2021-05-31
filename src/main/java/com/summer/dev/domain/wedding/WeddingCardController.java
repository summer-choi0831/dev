package com.summer.dev.domain.wedding;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WeddingCardController {

    @GetMapping("/wedding_card")
    public String wedding_card() {
        log.info("wedding_card 접속");
        return "wedding_card";
    }


    @PostMapping("/wedding_card/record")
    public void record(@RequestBody RecordRequest request) {
        log.info("record : " + request);
    }
}
