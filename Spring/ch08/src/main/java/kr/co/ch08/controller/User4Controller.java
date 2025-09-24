package kr.co.ch08.controller;

import jakarta.validation.Valid;
import kr.co.ch08.dto.User4DTO;
import kr.co.ch08.service.User4Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class User4Controller {
    private final User4Service user4Service;

    @GetMapping("/user4")
    public ResponseEntity<List<User4DTO>> list() {
        List<User4DTO> dtoList = user4Service.getUserAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoList);
    }

    @GetMapping("/user4/{no}")
    public ResponseEntity<User4DTO> user4(@PathVariable int no) {
        log.info("user4 ==> no={}", no);
        User4DTO savedUser4 = user4Service.getUser(no);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser4);
    }

    @PostMapping("/user4")
    public ResponseEntity<User4DTO> register(@Valid @RequestBody User4DTO user4DTO) {
        log.info("user4DTO={}", user4DTO);
        User4DTO savedUser4 = user4Service.save(user4DTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser4);
    }

    @ResponseBody
    @PutMapping("/user4")
    public ResponseEntity<User4DTO> modify(@RequestBody User4DTO user4DTO) {
        log.info("user4DTO={}", user4DTO);
        User4DTO modifiedUser4 = user4Service.modify(user4DTO);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(modifiedUser4);
    }

    @ResponseBody
    @DeleteMapping("/user4/{no}")
    public ResponseEntity<Boolean> delete(@PathVariable int no) {
        log.info("user4 ==> no={}", no);
        boolean isSuccess = user4Service.remove(no);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(isSuccess);
    }
}
