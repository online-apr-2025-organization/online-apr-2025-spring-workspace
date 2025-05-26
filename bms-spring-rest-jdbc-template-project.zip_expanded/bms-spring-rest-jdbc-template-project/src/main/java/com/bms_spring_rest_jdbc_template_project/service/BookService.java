package com.bms_spring_rest_jdbc_template_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms_spring_rest_jdbc_template_project.dao.BookDao;
import com.bms_spring_rest_jdbc_template_project.pojo.BookPojo;

//@Component
@Service
public class BookService {

	@Autowired
	BookDao bookDao;
	
	public List<BookPojo> getAllBooks(){
		return bookDao.getAllBooks();
	}
	
	public BookPojo getABook(int bookId) {
		return bookDao.getABook(bookId);
	}
	
	public void deleteBook(int bookId) {
		bookDao.deleteBook(bookId);
	}
	
	public BookPojo updateBook(BookPojo editBook) {
		return bookDao.updateBook(editBook);
	}
	
	public BookPojo addBook(BookPojo newBook) {
		return bookDao.addBook(newBook);
	}
}
