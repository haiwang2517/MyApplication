package org.gradle.service.impl;

import java.util.List;

import org.gradle.dao.UserDao;
import org.gradle.modle.User;
import org.gradle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> findUser() {
		return userDao.findUser();
	}

	@Override
	public User findUserByCode(String code) {
		return userDao.findUserByCode(code);
	}

}
