package org.gradle.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
        auth.inMemoryAuthentication().withUser("user").password("123").roles("USER");   //指定用户才可以登录
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()   // 禁用 csrf的验证
			.authorizeRequests()
				.antMatchers("/bootstrap/**/*","/login")
				.permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.usernameParameter("username")
	            .passwordParameter("password")
	            .loginPage("/login")// 登录的界面
	            
	            /*
	             * 不写loginProcessingUrl的话默认进入/路径对应的方法中
	             * 写loginProcessingUrl("/login") 也是直接到 / 路径对应的方法中 
	             * 写loginProcessingUrl("/signlogin") 写一个不存在的或者存在的就会进入Login 提交的后台处理中
	             * */
	            .loginProcessingUrl("/signloginabc")   
	            .failureUrl("/login?error")    //登录失败调用的界面
	            .permitAll()
	            .successHandler(loginSuccessHandler())
				.and()
			.logout()
				.permitAll();
		
	}
	
	@Bean  
    public LoginSuccessHandler loginSuccessHandler(){  
        return new LoginSuccessHandler();  
    }  
	
}
