package kr.co.ch08.service;

import kr.co.ch08.dto.User4DTO;
import kr.co.ch08.entity.User4;
import kr.co.ch08.repository.User4Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class User4Service {
    private final User4Repository user4Repository;

    public User4DTO save(User4DTO user4DTO) {
        User4 savedUser4 = user4Repository.save(user4DTO.toEntity());

        return savedUser4.toDTO();
    }

    public User4DTO getUser(int no) {
        Optional<User4> optUser4 = user4Repository.findById(no);

        if(optUser4.isPresent()) {
            User4 user4 = optUser4.get();
            return user4.toDTO();
        }
        return null;
    }

    public List<User4DTO> getUserAll() {
        List<User4> list = user4Repository.findAll();

        return list.stream()
                .map(entity -> entity.toDTO())
                .toList();
    }

    public User4DTO modify(User4DTO user4DTO) {
        if(user4Repository.existsById(user4DTO.getNo())) {
            User4 modifiedUser4 = user4Repository.save(user4DTO.toEntity());
            return modifiedUser4.toDTO();
        }
        return null;
    }

    public boolean remove(int no) {
        if(user4Repository.existsById(no)) {
            user4Repository.deleteById(no);
            return true;
        }
        return false;
    }
}
