package kr.co.ch08.controller;

import jakarta.validation.Valid;
import kr.co.ch08.dto.User3DTO;
import kr.co.ch08.service.User3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class User3Controller {
    private final User3Service user3Service;

    @GetMapping("/user3")
    public ResponseEntity<List<User3DTO>> list() {
        List<User3DTO> dtoList = user3Service.getUserAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoList);
    }

    @GetMapping("/user3/{userid}")
    public ResponseEntity<User3DTO> user3(@PathVariable("userid") String userid) {
        log.info("user3 ==> userid={}", userid);
        User3DTO user3DTO = user3Service.getUser(userid);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(user3DTO);
    }

    @PostMapping("/user3")
    public ResponseEntity<User3DTO> register(@Valid @RequestBody User3DTO user3DTO) {
        log.info("user3DTO={}", user3DTO);
        User3DTO savedUser3 = user3Service.save(user3DTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser3);
    }

    @ResponseBody
    @PutMapping("/user3")
    public ResponseEntity<User3DTO> modify(@RequestBody User3DTO user3DTO) {
        log.info("user3DTO={}", user3DTO);
        User3DTO modifiedUser3 = user3Service.modify(user3DTO);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(modifiedUser3);
    }

    @ResponseBody
    @DeleteMapping("/user3/{userid}")
    public ResponseEntity<Boolean> delete(@PathVariable("userid") String userid) {
        log.info("user3 ==> userid={}", userid);
        boolean isSuccess = user3Service.remove(userid);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(isSuccess);
    }
}
