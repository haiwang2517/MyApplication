package org.gradle.a;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
    @ResponseBody
    @RequestMapping(value = "id", method = { RequestMethod.POST })
//    @RequestMapping("/id" , method = "" )
    String home() {
        return "Hello World!";
    }
    
    @ResponseBody
    @RequestMapping("/{userId}/show")
    String show(@PathVariable String userId) {
        return "Hello World2!:"+userId;
    }
    
}
