package com.bms_spring_rest_jdbc_template_project.pojo;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BookPojo {
	private int bookId;
	private String bookTitle;
	private int bookAuthorId;
	private String bookGenre;
	private LocalDate bookPublished;
	private String bookImageUrl;
	
}
