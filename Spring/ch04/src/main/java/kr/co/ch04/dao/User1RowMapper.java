package kr.co.ch04.dao;

import kr.co.ch04.dto.User1DTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User1RowMapper implements RowMapper<User1DTO> {

    @Override
    public User1DTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        User1DTO user = new User1DTO();
        user.setUid(rs.getString("uid"));
        user.setName(rs.getString("name"));
        user.setBirth(rs.getString("birth"));
        user.setAge(rs.getInt("age"));

        return user;
    }
}
