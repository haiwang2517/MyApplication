package org.gradle.controller;

import org.gradle.comm.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PeopleController {
	private static Logger logger = LoggerFactory.getLogger(PeopleController.class);
	
	@RequestMapping("/")
	public String firstshow(ModelMap map){
		System.out.println("******* first index");
		map.addAttribute("firstRet", "My first project!");
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/second")
	public ResultDTO secondReturn(){
		ResultDTO dto = new ResultDTO<>();
		dto.success("成功啦");
		return dto;
	}
	
	@RequestMapping("/login")
	public String loginMethod(){
		
		return "login";
	}
	
	@RequestMapping(value = "/signlogin" , method = RequestMethod.POST)
	public String signLoginMethod(String username , String password){
		logger.info("用户名: {}  密码:{}", username , password);
		return "login";
	}
}
