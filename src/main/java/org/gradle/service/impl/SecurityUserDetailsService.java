package org.gradle.service.impl;

import java.util.Arrays;

import org.gradle.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("进入自定义SecurityUserDetailsService.loadUserByUsername:"+username);
		org.gradle.modle.User user = userDao.findUserByCode(username);
		
		if( null == user ){
			throw new BadCredentialsException("用户不存在");
		}
		
		GrantedAuthority authority = new SimpleGrantedAuthority("role");  //角色
		
		UserDetails userDetails = (UserDetails)new User(user.getCode(), 
				user.getPassword(),
				Arrays.asList(authority));
		
		return userDetails;
	}

}
