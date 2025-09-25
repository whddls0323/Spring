package kr.co.ch09.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import kr.co.ch09.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtProviderTest { //추가

    @Autowired
    private JwtProvider jwtProvider;

    @Test
    void createToken() {
        User user = User.builder()
                .usid("a101")
                .pass("1234")
                .name("홍길동")
                .role("ADMIN")
                .age(23)
                .build();

        String token = jwtProvider.createToken(user, -1); //-1은 토큰 만료 상태, 1은 하루 유효
        System.out.println(token);
    }

    @Test
    void getClaims() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3aGRkbHMwMzIzQGdtYWlsLmNvbSIsImlhdCI6MTc1ODc2OTgyNywiZXhwIjoxNzU4ODU2MjI3LCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.YoPJixmlzkWg2ygTzUQTrfHVWq1Zu_I31tzWr7DmFEA";

        Claims claims = jwtProvider.getClaims(token);
        System.out.println("claims: " + claims);
    }

    @Test
    void getAuthentication() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3aGRkbHMwMzIzQGdtYWlsLmNvbSIsImlhdCI6MTc1ODc2OTgyNywiZXhwIjoxNzU4ODU2MjI3LCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.YoPJixmlzkWg2ygTzUQTrfHVWq1Zu_I31tzWr7DmFEA";

        Authentication authentication = jwtProvider.getAuthentication(token);
        User user = (User) authentication.getPrincipal();

        System.out.println(user);
    }

    @Test
    void validateToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3aGRkbHMwMzIzQGdtYWlsLmNvbSIsImlhdCI6MTc1ODc2OTgyNywiZXhwIjoxNzU4ODU2MjI3LCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.YoPJixmlzkWg2ygTzUQTrfHVWq1Zu_I31tzWr7DmFEA";
        String expiredToken = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3aGRkbHMwMzIzQGdtYWlsLmNvbSIsImlhdCI6MTc1ODc3MDg2MywiZXhwIjoxNzU4Njg0NDYzLCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.9CuSdeOXSrqZgi0wbjjlOqiGzg63Fmq_tdDYbi8bQJM";

        try {
            jwtProvider.validateToken(expiredToken);
            System.out.println("토큰 이상 없음...");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}