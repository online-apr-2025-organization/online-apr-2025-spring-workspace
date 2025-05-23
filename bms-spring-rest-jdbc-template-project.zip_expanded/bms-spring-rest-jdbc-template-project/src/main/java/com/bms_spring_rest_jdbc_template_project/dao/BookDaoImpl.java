package com.bms_spring_rest_jdbc_template_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bms_spring_rest_jdbc_template_project.pojo.BookPojo;

public class BookDaoImpl implements BookDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BookPojo> getAllBooks() {
		List<BookPojo> allBooks = jdbcTemplate.query("select * from book_details", BeanPropertyRowMapper.newInstance(BookPojo.class));
		return allBooks;
	}

	@Override
	public BookPojo getABook(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookPojo addBook(BookPojo newBook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookPojo updateBook(BookPojo editBook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBook(int bookId) {
		// TODO Auto-generated method stub
		
	}

}
