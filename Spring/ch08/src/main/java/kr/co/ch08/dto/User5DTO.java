package kr.co.ch08.dto;

import kr.co.ch08.entity.User5;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User5DTO {
    private int no;
    private String name;
    private int age;
    private String gender;
    private String regDate;

    public User5 toEntity() {
        return User5.builder()
                .no(no)
                .name(name)
                .age(age)
                .gender(gender)
                .build();
    }
}
