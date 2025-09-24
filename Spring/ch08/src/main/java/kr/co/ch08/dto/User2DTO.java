package kr.co.ch08.dto;

import kr.co.ch08.entity.User2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User2DTO {
    private String userid;
    private String name;
    private int age;
    private String address;

    public User2 toEntity() {
        return User2.builder()
                .userid(userid)
                .name(name)
                .age(age)
                .address(address)
                .build();
    }
}
