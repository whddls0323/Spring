package kr.co.ch08.service;

import kr.co.ch08.dto.User5DTO;
import kr.co.ch08.entity.User5;
import kr.co.ch08.repository.User5Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class User5Service {
    private final User5Repository user5Repository;

    public User5DTO save(User5DTO user5DTO) {
        User5 savedUser5 = user5Repository.save(user5DTO.toEntity());

        return savedUser5.toDTO();
    }

    public User5DTO getUser(int no) {
        Optional<User5> optUser5 = user5Repository.findById(no);

        if(optUser5.isPresent()) {
            User5 user5 = optUser5.get();
            return user5.toDTO();
        }
        return null;
    }

    public List<User5DTO> getUserAll() {
        List<User5> list = user5Repository.findAll();

        return list.stream()
                .map(entity -> entity.toDTO())
                .toList();
    }

    public User5DTO modify(User5DTO user5DTO) {
        if(user5Repository.existsById(user5DTO.getNo())) {
            User5 modifiedUser5 = user5Repository.save(user5DTO.toEntity());
            return modifiedUser5.toDTO();
        }
        return null;
    }

    public boolean remove(int no) {
        if(user5Repository.existsById(no)) {
            user5Repository.deleteById(no);
            return true;
        }
        return false;
    }
}
