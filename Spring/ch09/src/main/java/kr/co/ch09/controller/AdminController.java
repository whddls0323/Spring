package kr.co.ch09.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController { //추가
    @GetMapping(value = {"/admin/", "/admin/index"})
    public String index() {
        return "admin/index";
    }
}
