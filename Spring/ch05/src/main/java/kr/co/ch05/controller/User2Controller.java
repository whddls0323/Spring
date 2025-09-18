package kr.co.ch05.controller;

import kr.co.ch05.dto.User2DTO;
import kr.co.ch05.service.User2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User2Controller {
    private final User2Service service;

    @GetMapping("/user2/register")
    public String register() {
        return "/user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2DTO user2DTO) {
        System.out.println(user2DTO);

        service.regist(user2DTO);

        return "redirect:/user2/list";
    }

    @GetMapping("/user2/list")
    public String list(Model model) {
        List<User2DTO> dtoList = service.findAll();

        model.addAttribute("dtoList", dtoList);

        return "/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(@RequestParam("uid") String uid, Model model) {
        User2DTO user2DTO = service.findById(uid);

        model.addAttribute("user2DTO", user2DTO);

        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(User2DTO user2DTO) {
        service.modify(user2DTO);

        return "redirect:/user2/list";
    }

    @GetMapping("/user2/delete")
    public String delete(String uid) {
        service.remove(uid);

        return "redirect:/user2/list";
    }
}
