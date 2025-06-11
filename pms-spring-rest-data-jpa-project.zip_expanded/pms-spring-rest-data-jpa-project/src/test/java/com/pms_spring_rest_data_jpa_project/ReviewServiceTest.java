package com.pms_spring_rest_data_jpa_project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pms_spring_rest_data_jpa_project.dao.entity.ReviewEntity;
import com.pms_spring_rest_data_jpa_project.service.ReviewService;

@SpringBootTest
public class ReviewServiceTest {

	@Autowired
	ReviewService reviewService;
	
	@Test
	@DisplayName("Test count of reviews")
	public void testGetAllReviewsCount() {
		int expectedReviewsCount = 5;
		int actualReviewsCount;
		
		//ReviewService reviewService = new ReviewService();
		actualReviewsCount = reviewService.getAllReviews().size();
		
		assertEquals(expectedReviewsCount, actualReviewsCount);
	}
	
	@Test
	@DisplayName("Test Fetch A Review with existing review id")
	public void testGetAReviewExists() {
		//boolean expectedOutput = true;
		boolean actualOutput = reviewService.getAReview(1).isPresent();
		
		assertTrue(actualOutput);
		
	}
	
	@Test
	@DisplayName("Test Fetch A Review with non-existing review id")
	public void testGetAReviewNotExists() {
		//boolean expectedOutput = true;
		boolean actualOutput = reviewService.getAReview(123).isPresent();
		
		assertFalse(actualOutput);
		
	}
}
