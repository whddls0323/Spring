package kr.co.ch04.mapper;

import kr.co.ch04.dto.User1DTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class User1MapperTest {

    @Autowired
    private User1Mapper user1Mapper;
    private final String userId = "a104";

    @Order(1)
    @DisplayName("등록 테스트")
    @Test
    void insert() {
        //Given - 테스트를 실행하기 위한 준비 단계
        User1DTO user1DTO = User1DTO.builder()
                                    .uid(userId)
                                    .name("김유신")
                                    .birth("1992-01-03")
                                    .age(21)
                                    .build();
        //When - 테스트 수행
        user1Mapper.insert(user1DTO);

        //Then - 테스트 결과를 검증
        User1DTO savedUser = user1Mapper.select(user1DTO.getUid());
        assertEquals(user1DTO.getUid(), savedUser.getUid());
    }

    @Order(2)
    @DisplayName("조회 테스트")
    @Test
    void select() {
        //Given
        //String uid = "a102";

        //When
        User1DTO findUser = user1Mapper.select(userId);

        //Then
        System.out.println(findUser);
        assertEquals(userId, findUser.getUid());
    }

    @Order(5)
    @DisplayName("전체 조회 테스트")
    @Test
    void selectAll() {
        //When
        List<User1DTO> dtoList = user1Mapper.selectAll();

        //Then
        System.out.println(dtoList);

        //assertTrue(dtoList.isEmpty()); //테스트 실패로 출력
        assertFalse(dtoList.isEmpty()); //테스트 성공으로 출력
    }

    @Order(3)
    @DisplayName("수정 테스트")
    @Test
    void update() {
        //Given
        User1DTO user1DTO = User1DTO.builder()
                                    .uid(userId)
                                    .name("김민호")
                                    .birth("1992-01-03")
                                    .age(33)
                                    .build();
        //When
        user1Mapper.update(user1DTO);

        //Then
        User1DTO modifiedUser = user1Mapper.select(user1DTO.getUid());
        assertEquals(user1DTO, modifiedUser); // 객체 비교를 위해 DTO에 @Data 어노테이션 선언
    }

    @Order(4)
    @DisplayName("삭제 테스트")
    @Test
    void delete() {

        //Given
        //String uid = "a102";

        //When
        user1Mapper.delete(userId);

        //Then
        User1DTO removedUser = user1Mapper.select(userId);
        assertNull(removedUser);
    }
}