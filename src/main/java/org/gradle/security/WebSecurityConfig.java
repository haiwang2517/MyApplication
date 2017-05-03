package org.gradle.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
				.antMatchers("/bootstrap/**/*","/").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
		
		/*
		 ͨ��@EnableWebSecurityע�⿪��Spring Security�Ĺ���
		�̳�WebSecurityConfigurerAdapter������д���ķ���������һЩweb��ȫ��ϸ��
		configure(HttpSecurity http)����
		ͨ��authorizeRequests()������ЩURL��Ҫ����������Щ����Ҫ���������������ϴ���ָ����/��/home����Ҫ�κ���֤�Ϳ��Է��ʣ�������·��������ͨ�������֤��
		ͨ��formLogin()���嵱��Ҫ�û���¼ʱ��ת���ĵ�¼ҳ�档
		configureGlobal(AuthenticationManagerBuilder auth)���������ڴ��д�����һ���û������û�������Ϊuser������Ϊpassword���û���ɫΪUSER�� 
		*/
		
	}
	
}
