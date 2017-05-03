package org.gradle.controller;

import org.gradle.comm.ResultDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PeopleController {
	
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
		dto.success("³É¹¦À²");
		return dto;
	}
	
	@RequestMapping("login")
	public String loginMethod(){
		
		return "login";
	}
}
