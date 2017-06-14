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
	
	@RequestMapping("/index")
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
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String loginMethod(){
		System.out.println("login-进入方法");
		return "login";
	}
	
//	@RequestMapping(value = "/signlogin" , method = RequestMethod.POST)
//	public String signLoginMethod(String username , String password){
//		logger.info("用户名: {}  密码:{}", username , password);
//		return "home";
//	}
	
//	@RequestMapping(value = "/signlogin" , method = RequestMethod.GET)
//	public String getLogin(String username , String password){
//		logger.info("用户名: {}  密码:{}", username , password);
//		return "home";
//	}
	
	
	@RequestMapping(value = "/home" )
	public String showHome(){
		logger.info("登录成功sss");
		return "home";
	}
	
	@RequestMapping(value = "/test1" )
	public String test1(){
		logger.info("test1");
		return "test1";
	}
	
	@RequestMapping(value = "/test2" )
	public String test2(){
		logger.info("test2");
		return "test2";
	}
	
	/**
	 * 查询图书列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findBooks")
	public ResultDTO findBooks(){
		ResultDTO dto = new ResultDTO<>();
		dto.success("成功啦");
		return dto;
	} 
}
