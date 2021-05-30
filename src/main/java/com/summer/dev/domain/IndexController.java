package com.summer.dev.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

    @GetMapping("/wedding_card")
    public String wedding_card() {
        log.info("wedding_card 접속");
        return "wedding_card";
    }
}
