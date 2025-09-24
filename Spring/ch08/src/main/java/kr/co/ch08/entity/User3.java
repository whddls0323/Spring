package kr.co.ch08.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch08.dto.User3DTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_USER3")
public class User3 {
    @Id
    private String userid;
    private String name;
    private String role;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime regDate;

    public User3DTO toDTO() {
        return User3DTO.builder()
                .userid(userid)
                .name(name)
                .role(role)
                .regDate(regDate != null ? regDate.toString() : null)
                .build();
    }
}
