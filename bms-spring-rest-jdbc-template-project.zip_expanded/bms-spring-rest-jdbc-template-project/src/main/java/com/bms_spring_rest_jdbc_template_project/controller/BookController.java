package com.bms_spring_rest_jdbc_template_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms_spring_rest_jdbc_template_project.pojo.BookPojo;
import com.bms_spring_rest_jdbc_template_project.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
	BookService bookService;
	
	// GET     http://localhost:4545/api/books     
	@GetMapping("/books")
	public List<BookPojo> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	// GET     http://localhost:4545/api/books/11
	@GetMapping("/books/{bid}")
	public BookPojo getABook(@PathVariable("bid") int bookId) {
		return bookService.getABook(bookId);
	}
	
	// DELETE     http://localhost:4545/api/books/11
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable int bookId) {
		bookService.deleteBook(bookId);
	}
	
	// PUT     http://localhost:4545/api/books 
	@PutMapping("/books")
	public BookPojo updateBook(@RequestBody BookPojo editPojo) {
		return bookService.updateBook(editPojo);
	}
	
	// POST     http://localhost:4545/api/books 
	@PostMapping("/books")
	public BookPojo addBook(@RequestBody BookPojo newBook) {
		return bookService.addBook(newBook);
	}
	
}
