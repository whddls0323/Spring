package kr.co.ch08.dto;

import kr.co.ch08.entity.User4;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User4DTO {
    private int no;
    private String name;
    private int age;
    private String address;

    public User4 toEntity() {
        return User4.builder()
                .no(no)
                .name(name)
                .age(age)
                .address(address)
                .build();
    }
}
