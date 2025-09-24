package kr.co.ch08.controller;

import jakarta.validation.Valid;
import kr.co.ch08.dto.User5DTO;
import kr.co.ch08.service.User5Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class User5Controller {
    private final User5Service user5Service;

    @GetMapping("/user5")
    public ResponseEntity<List<User5DTO>> list() {
        List<User5DTO> dtoList = user5Service.getUserAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoList);
    }

    @GetMapping("/user5/{no}")
    public ResponseEntity<User5DTO> user5(@PathVariable int no) {
        log.info("user5 ==> no={}", no);
        User5DTO savedUser5 = user5Service.getUser(no);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser5);
    }

    @PostMapping("/user5")
    public ResponseEntity<User5DTO> register(@Valid @RequestBody User5DTO user5DTO) {
        log.info("user5 ==> user5DTO={}", user5DTO);
        User5DTO savedUser5 = user5Service.save(user5DTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser5);
    }

    @ResponseBody
    @PutMapping("/user5")
    public ResponseEntity<User5DTO> modify(@RequestBody User5DTO user5DTO) {
        log.info("user5DTO={}", user5DTO);
        User5DTO modifiedUser5 = user5Service.modify(user5DTO);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(modifiedUser5);
    }

    @ResponseBody
    @DeleteMapping("/user5/{no}")
    public ResponseEntity<Boolean> delete(@PathVariable int no) {
        log.info("user5 ==> no={}", no);
        boolean isSuccess = user5Service.remove(no);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(isSuccess);
    }
}
