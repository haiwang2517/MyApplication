package org.gradle.controller;

import org.gradle.comm.ResultDTO;
import org.gradle.modle.Books;
import org.gradle.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	@Autowired
	private BooksService bookServiceImpl;
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/findAll" , method = RequestMethod.GET)
	public ResultDTO findAll(){
		Books book  = null;
		ResultDTO dto = new ResultDTO<Books>();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			System.out.println("当前登录:["+userDetails.getUsername()+"],密码:["+userDetails.getPassword()+"]");
			book = bookServiceImpl.findBooks();
			dto.success(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
