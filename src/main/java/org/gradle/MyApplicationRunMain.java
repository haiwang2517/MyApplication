package org.gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
public class MyApplicationRunMain {
	
	public static void main (String [] args){
		
		SpringApplication.run(MyApplicationRunMain.class, args);
	
	}
}	
