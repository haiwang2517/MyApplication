package org.gradle.modle;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class BookResultSetExtractor implements ResultSetExtractor<Books> {
	
	
	@Override
	public Books extractData(ResultSet rs) throws SQLException, DataAccessException {
		if( !rs.next() ){
			return null;
		}
		Books book = new Books();
		book.setId(rs.getLong("id"));
		book.setCode(rs.getString("code"));
		book.setName(rs.getString("name"));
		book.setCreate(rs.getTimestamp("create"));
		book.setStatus(rs.getInt("status"));
		return book;
	}

}
