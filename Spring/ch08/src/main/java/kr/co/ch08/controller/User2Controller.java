package kr.co.ch08.controller;

import jakarta.validation.Valid;
import kr.co.ch08.dto.User2DTO;
import kr.co.ch08.service.User2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class User2Controller {
    private final User2Service user2Service;

    @GetMapping("/user2")
    public ResponseEntity<List<User2DTO>> list() {
        List<User2DTO> dtoList = user2Service.getUserAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(dtoList);
    }

    @GetMapping("/user2/{userid}")
    public ResponseEntity<User2DTO> user2(@PathVariable("userid") String userid) {
        log.info("user2 ==> userid={}", userid);
        User2DTO user2DTO = user2Service.getUser(userid);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(user2DTO);
    }

    @PostMapping("/user2")
    public ResponseEntity<User2DTO> register(@Valid @RequestBody User2DTO user2DTO) {
        log.info("user2DTO={}", user2DTO);
        User2DTO savedUser2 = user2Service.save(user2DTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser2);
    }

    @ResponseBody
    @PutMapping("/user2")
    public ResponseEntity<User2DTO> modify(@RequestBody User2DTO user2DTO) {
        log.info("user2DTO={}", user2DTO);
        User2DTO modifiedUser2 = user2Service.modify(user2DTO);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(modifiedUser2);
    }

    @ResponseBody
    @DeleteMapping("/user2/{userid}")
    public ResponseEntity<Boolean> delete(@PathVariable("userid") String userid) {
        log.info("user2 ==> userid={}", userid);
        boolean isSuccess = user2Service.remove(userid);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(isSuccess);
    }
}
