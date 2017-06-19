package org.gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

//@ComponentScan
@Configuration
@SpringBootApplication
@EnableAutoConfiguration
public class MyApplicationRunMain {
	
	public static void main (String [] args){
		
		SpringApplication.run(MyApplicationRunMain.class, args);
	
	}
}	
