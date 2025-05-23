package com.bms_spring_rest_jdbc_template_project.dao;

import java.util.List;

import com.bms_spring_rest_jdbc_template_project.pojo.BookPojo;

public interface BookDao {
	List<BookPojo> getAllBooks();
	BookPojo getABook(int bookId);
	BookPojo addBook(BookPojo newBook);
	BookPojo updateBook(BookPojo editBook);
	void deleteBook(int bookId);
}
