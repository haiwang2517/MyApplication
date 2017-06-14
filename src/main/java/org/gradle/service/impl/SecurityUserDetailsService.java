package org.gradle.service.impl;

import java.util.Arrays;

import org.gradle.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.AuthenticationException;
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
	
	@SuppressWarnings("serial")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("进入SecurityUserDetailsService.loadUserByUsername:"+username);
		org.gradle.modle.User user = userDao.findUserByCode(username);
		
		if( null == user ){
			throw new UsernameNotFoundException("用户不存在") {};
		}
		
		ShaPasswordEncoder ss = new ShaPasswordEncoder();
		String ret = ss.encodePassword("haiyinlong", null);
		String ret2 = ss.encodePassword("haiyinlong", true);
		System.out.println("haiyinlong:["+ret+"],解析:["+ss.isPasswordValid( "c4eb70b9f3d8f4860a16b97650426ea22785f6ad","haiyinlong", null)+"]");   // c4eb70b9f3d8f4860a16b97650426ea22785f6ad
		System.out.println("haiyinlong:["+ret2+"],解析:["+ss.isPasswordValid( "0aa74671a97606c21f8bf2f4d8c187614c165383","haiyinlong", true)+"]");  // 0aa74671a97606c21f8bf2f4d8c187614c165383
		
		GrantedAuthority authority = new SimpleGrantedAuthority("role");  //角色
		
		UserDetails userDetails = (UserDetails)new User(user.getCode(), 
				user.getPassword(),//ss.encodePassword(user.getPassword(),null),
				Arrays.asList(authority));
		
		return userDetails;
	}

}
