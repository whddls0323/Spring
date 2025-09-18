package kr.co.ch05.service;

import kr.co.ch05.dto.User3DTO;
import kr.co.ch05.mapper.User3Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User3Service {
    private final User3Mapper mapper;

    public List<User3DTO> findAll() {
        return mapper.selectAllUser3();
    }
    public User3DTO findById(String uid) {
        return mapper.selectUser3(uid);
    }
    public void regist(User3DTO user3DTO) {
        mapper.insertUser3(user3DTO);
    }
    public void modify(User3DTO user3DTO) {
        mapper.updateUser3(user3DTO);
    }
    public void remove(String uid) {
        mapper.deleteUser3(uid);
    }
}
