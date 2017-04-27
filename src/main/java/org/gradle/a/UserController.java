package org.gradle.a;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
    @GetMapping(value = "id")
    String home() {
        return "Hello World!";
    }
    
    @GetMapping(value = "/{userId}/show")
    String show(@PathVariable String userId) {
        return "Hello World2!:"+userId;
    }
    
}
