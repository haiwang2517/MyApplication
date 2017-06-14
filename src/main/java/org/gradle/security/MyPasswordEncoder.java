package org.gradle.security;

import org.springframework.security.authentication.encoding.PasswordEncoder;

public class MyPasswordEncoder implements PasswordEncoder {

	@Override
	public String encodePassword(String rawPass, Object salt) {
		System.out.println("rawPass:["+rawPass+"],sal:["+salt+"]");
		return "";
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		System.out.println("encPass:["+encPass+"],rawPass:["+rawPass+"],salt:["+salt+"]");
		return true;
	}

}
