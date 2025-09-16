package kr.co.ch03.controller;

import kr.co.ch03.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Sub2Controller {

    @GetMapping("/sub2/register")
    public String register(){
        return "/sub2/register";
    }

    @PostMapping("/sub2/register")
    public String register(UserDTO userDTO) {
        System.out.println(userDTO.toString());

        return "redirect:/index";
    }
}
