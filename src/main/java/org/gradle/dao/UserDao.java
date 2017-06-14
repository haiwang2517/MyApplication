package org.gradle.dao;

import java.util.List;

import org.gradle.modle.User;
import org.gradle.modle.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String FIND_SQL = "select * from user";
	
	public List<User> findUser(){
		return jdbcTemplate.query(FIND_SQL, new UserRowMapper());
	}
	
	@SuppressWarnings("unused")
	public User findUserByCode(String code){
		List<User> user =  jdbcTemplate.query("select * from my_user where code = ? ",new Object[]{code}, new UserRowMapper());
		//"select * from USER where code = '"+code+"' ", new UserRowMapper()
		List<User> users =  jdbcTemplate.query("select * from my_user where code = ? ",new Object[]{code}, new UserRowMapper());
		
		if( null ==  user || user.size() == 0 ){
			return null;
		}
		return user.get(0);
	}
}
