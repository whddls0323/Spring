package kr.co.ch08.service;

import kr.co.ch08.dto.User2DTO;
import kr.co.ch08.entity.User2;
import kr.co.ch08.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class User2Service {
    private final User2Repository user2Repository;

    public User2DTO save(User2DTO user2DTO) {
        User2 savedUser2 = user2Repository.save(user2DTO.toEntity());

        return savedUser2.toDTO();
    }

    public User2DTO getUser(String userid) {
        Optional<User2> optUser2 = user2Repository.findById(userid);

        if(optUser2.isPresent()) {
            User2 user2 = optUser2.get();
            return user2.toDTO();
        }
        return null;
    }

    public List<User2DTO> getUserAll() {
        List<User2> list = user2Repository.findAll();

        return list.stream()
                .map(entity -> entity.toDTO())
                .toList();
    }

    public User2DTO modify(User2DTO user2DTO) {
        if(user2Repository.existsById(user2DTO.getUserid())) {
            User2 modifiedUser2 = user2Repository.save(user2DTO.toEntity());
            return modifiedUser2.toDTO();
        }
        return null;
    }

    public boolean remove(String userid) {
        if(user2Repository.existsById(userid)) {
            user2Repository.deleteById(userid);
            return true;
        }
        return false;
    }
}
