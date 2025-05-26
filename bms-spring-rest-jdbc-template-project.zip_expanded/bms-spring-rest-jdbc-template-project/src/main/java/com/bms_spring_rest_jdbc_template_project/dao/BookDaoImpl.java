package com.bms_spring_rest_jdbc_template_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bms_spring_rest_jdbc_template_project.pojo.BookPojo;

//@Component
@Repository
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
		try {
			BookPojo fetchedBook = jdbcTemplate.queryForObject("select * from book_details where book_id=?", BeanPropertyRowMapper.newInstance(BookPojo.class), bookId);
			return fetchedBook;
		}catch(IncorrectResultSizeDataAccessException d) {
			return null;
		}
	}

	@Override
	public BookPojo addBook(BookPojo newBook) {
		jdbcTemplate.update("insert into book_details(book_title, book_author_id, book_genre, book_published, book_cost, book_image_url) values(?, ?, ?, ? , ?, ?)",new Object[] {newBook.getBookTitle(), newBook.getBookAuthorId(), newBook.getBookGenre(), newBook.getBookPublished(), 555, newBook.getBookImageUrl()});
		int newBookId = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
		newBook.setBookId(newBookId);
		return newBook;
	}

	@Override
	public BookPojo updateBook(BookPojo editBook) {
		jdbcTemplate.update("update book_details set book_title=? , book_genre=? where book_id=?", new Object[] {editBook.getBookTitle(), editBook.getBookGenre(), editBook.getBookId()});
		return editBook;
	}

	@Override
	public void deleteBook(int bookId) {
		jdbcTemplate.update("delete from book_details where book_id=?", bookId);
	}

}
