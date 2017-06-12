package org.gradle.service.impl;

import org.gradle.dao.BooksDao;
import org.gradle.modle.Books;
import org.gradle.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BooksDao booksDao;
	
	@Override
	public Books findBooks() {
		Books book = booksDao.findBooks();
		return book;
	}

}
