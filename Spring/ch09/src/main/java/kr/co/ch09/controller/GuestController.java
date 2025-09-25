package kr.co.ch09.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestController { //추가
    @GetMapping(value = {"/guest/", "/guest/index"})
    public String index() {
        return "guest/index";
    }
}
