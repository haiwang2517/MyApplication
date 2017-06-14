package org.gradle.modle;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

//		if( !rs.next() ){
//			return null;
//		}
		
		User user = new User();
		user.setAccess(rs.getString("access"));
		user.setCode(rs.getString("code"));
		user.setCreate(rs.getTimestamp("create"));
		user.setId(rs.getLong("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		return user;
	}

}
