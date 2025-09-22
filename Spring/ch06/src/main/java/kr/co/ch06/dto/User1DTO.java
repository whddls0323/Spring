package kr.co.ch06.dto;

import kr.co.ch06.entity.User1;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User1DTO {
    private String userid;
    private String name;
    private String birth;
    private int age;

    //Entity 변환 메서드 정의
    public User1 toEntity() {
        return User1.builder()
                .userid(userid)
                .name(name)
                .birth(birth)
                .age(age)
                .build();
    }
}
