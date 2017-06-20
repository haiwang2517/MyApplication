package org.gradle.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class MyPasswordEncoder extends ShaPasswordEncoder {
	
	Logger logger = LoggerFactory.getLogger(MyPasswordEncoder.class);
	
	@Override
	public String encodePassword(String rawPass, Object salt) {
		logger.info("rawPass:["+rawPass+"],sal:["+salt+"]");
		return super.encodePassword(rawPass, salt);
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		logger.info("encPass:["+encPass+"],rawPass:["+rawPass+"],salt:["+salt+"]");
		return super.isPasswordValid(encPass, rawPass, salt);
	}

}
