package org.gradle.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailService;
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        
//		auth.inMemoryAuthentication().withUser("user").password("123").roles("USER");   //指定用户才可以登录
		auth.eraseCredentials(false).userDetailsService(userDetailService).passwordEncoder(myPasswordEncoder());
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
	            .loginProcessingUrl("/login").successForwardUrl("/home").defaultSuccessUrl("/index")
	            .successHandler(loginSuccessHandler())
	            .failureUrl("/login?error")    //登录失败调用的界面
	            
	            .permitAll()
				.and()
			.logout()
				.permitAll();
		
	}
	
	@Bean  
    public LoginSuccessHandler loginSuccessHandler(){  
        return new LoginSuccessHandler();  
    }  
	
	@Bean
	public MessageDigestPasswordEncoder myPasswordEncoder(){
		return new MyPasswordEncoder();
	}
}
