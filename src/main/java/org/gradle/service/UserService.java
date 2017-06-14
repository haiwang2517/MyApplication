package org.gradle.service;

import java.util.List;

import org.gradle.modle.User;

public interface UserService {
	
	List<User> findUser();
	
	User findUserByCode(String code);
	
}
