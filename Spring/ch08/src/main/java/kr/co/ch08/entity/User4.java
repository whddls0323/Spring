package kr.co.ch08.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch08.dto.User4DTO;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_USER4")
public class User4 {
    @Id
    private int no;
    private String name;
    private int age;
    private String address;

    public User4DTO toDTO() {
        return User4DTO.builder()
                .no(no)
                .name(name)
                .age(age)
                .address(address)
                .build();
    }
}
