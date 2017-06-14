package org.gradle.dao;

import org.gradle.modle.BookResultSetExtractor;
import org.gradle.modle.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BooksDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Books findBooks(){
		Books book = jdbcTemplate.query("SELECT * FROM books where id = 1 ",new Object[]{},new BookResultSetExtractor());
		return book;
	}
	
}
