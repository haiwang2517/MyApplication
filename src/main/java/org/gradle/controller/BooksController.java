package org.gradle.controller;

import org.gradle.comm.ResultDTO;
import org.gradle.modle.Books;
import org.gradle.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	@Autowired
	private BooksService bookServiceImpl;
	
	@RequestMapping(value = "/findAll" , method = RequestMethod.GET)
	public ResultDTO findAll(){
		Books book  = null;
		ResultDTO dto = new ResultDTO<Books>();
		try {
			book = bookServiceImpl.findBooks();
			dto.success(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
