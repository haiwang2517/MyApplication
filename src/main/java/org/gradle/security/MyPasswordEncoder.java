package org.gradle.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class MyPasswordEncoder extends ShaPasswordEncoder {
	
	Logger logger = LoggerFactory.getLogger(MyPasswordEncoder.class);
	
	@Override
	public String encodePassword(String rawPass, Object salt) {
		logger.info("加密");
//		return super.encodePassword(rawPass, salt);
		
		//自定义密码加密,随便加个字母
		return rawPass+"*1";
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		logger.info("验证密码");
//		return super.isPasswordValid(encPass, rawPass, salt);
		
		String retPass = encodePassword(rawPass,salt);
		boolean passwordValid = retPass.equals(encPass);
		if( !passwordValid ){
			throw new BadCredentialsException("密码错误");
		}
		return passwordValid ;
	}
	

}
