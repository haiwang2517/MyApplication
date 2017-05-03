package org.gradle.controller;

import org.gradle.comm.ResultDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
@RequestMapping("/user")
public class UserController {
	
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/id")
    public ResultDTO home() {
    	
    	ResultDTO resultDto = new ResultDTO();
    	
    	resultDto.success( "Hello World!" );
        
    	return resultDto;
    }
    
    @GetMapping(value = "/{userId}/show")
    String show(@PathVariable String userId) {
        return "Hello World2!:"+userId;
    }
  
    
}
