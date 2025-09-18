package kr.co.ch05.service;

import kr.co.ch05.dto.User2DTO;
import kr.co.ch05.mapper.User2Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User2Service {
    //상단 @RequiredArgsConstructor로 의존성 주입
    private final User2Mapper mapper;

    public List<User2DTO> findAll() {
        return mapper.selectAllUser2();
    }
    public User2DTO findById(String uid) {
        return mapper.selectUser2(uid);
    }
    public void regist(User2DTO user2DTO) {
        mapper.insertUser2(user2DTO);
    }
    public void modify(User2DTO user2DTO) {
        mapper.updateUser2(user2DTO);
    }
    public void remove(String uid) {
        mapper.deleteUser2(uid);
    }
}
