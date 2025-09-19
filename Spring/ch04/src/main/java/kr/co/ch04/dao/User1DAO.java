package kr.co.ch04.dao;

import kr.co.ch04.dto.User1DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class User1DAO {
    private final JdbcTemplate jdbcTemplate;

    public void insert(User1DTO user1DTO) {
        String sql = "insert into user1 values(?,?,?,?)";
        Object[] params = {
                user1DTO.getUid(),
                user1DTO.getName(),
                user1DTO.getBirth(),
                user1DTO.getAge()
        };
        jdbcTemplate.update(sql, params); //executeUpdate() 실행
    }

    public User1DTO select(String uid) {
        String sql = "select * from user1 where \"UID\" = ?";
        return jdbcTemplate.queryForObject(sql, new User1RowMapper(), uid);
    }

    public List<User1DTO> selectAll() {
        String sql = "select * from user1";
        return jdbcTemplate.query(sql, new User1RowMapper());
    }

    public void update(User1DTO user1DTO) {
        String  sql = "update user1 set name = ?, birth = ?, age = ? where \"UID\" = ?";

        Object[] params = {
                user1DTO.getName(),
                user1DTO.getBirth(),
                user1DTO.getAge(),
                user1DTO.getUid()
        };

        jdbcTemplate.update(sql, params);
    }

    public void delete(String uid) {
        String sql = "delete from user1 where \"UID\" = ?";
        jdbcTemplate.update(sql, uid);
    }
}
