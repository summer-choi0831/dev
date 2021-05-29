package com.summer.dev.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    @GetMapping("/wedding_card")
    public String index(){
        return "wedding_card";
    }
}
