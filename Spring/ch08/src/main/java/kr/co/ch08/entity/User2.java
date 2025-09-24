package kr.co.ch08.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch08.dto.User2DTO;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_USER2")
public class User2 {
    @Id
    private String userid;
    private String name;
    private int age;
    private String address;

    public User2DTO toDTO() {
        return User2DTO.builder()
                .userid(userid)
                .name(name)
                .age(age)
                .address(address)
                .build();
    }
}
