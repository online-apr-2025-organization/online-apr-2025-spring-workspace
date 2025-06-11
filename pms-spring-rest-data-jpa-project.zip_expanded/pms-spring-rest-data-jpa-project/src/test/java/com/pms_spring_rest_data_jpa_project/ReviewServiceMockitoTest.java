package com.pms_spring_rest_data_jpa_project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.pms_spring_rest_data_jpa_project.dao.ReviewDao;
import com.pms_spring_rest_data_jpa_project.dao.entity.ProductEntity;
import com.pms_spring_rest_data_jpa_project.dao.entity.ReviewEntity;
import com.pms_spring_rest_data_jpa_project.service.ReviewService;

@SpringBootTest
public class ReviewServiceMockitoTest {
	@Mock
	ReviewDao reviewDao;
	
	@InjectMocks
	ReviewService reviewService;
	
	@Test
	@DisplayName("Test count of reviews")
	public void testGetAllReviewsCount() {
		// create the dummy data
		List<ReviewEntity> allDummyReviews = List.of(new ReviewEntity(101, 4, "Good", new ProductEntity(2001,"", "", 300, "", "", null)), new ReviewEntity(101, 4, "Good", new ProductEntity(2002,"", "", 300, "", "", null)));
		int expectedOuput = allDummyReviews.size();
		
		// create the mockito rule
		when(reviewDao.findAll()).thenReturn(allDummyReviews);
		
		List<ReviewEntity> allReviews = reviewService.getAllReviews();
		int actualOutput = allReviews.size();
		
		assertEquals(expectedOuput, actualOutput);
	}
	
	@Test
	@DisplayName("Test Fetch A Review with existing review id")
	public void testGetAReviewExists() {
		Optional<ReviewEntity> dummyOptional = Optional.of(new ReviewEntity(101, 4, "Good", new ProductEntity(2001,"", "", 300, "", "", null)));
		when(reviewDao.findById(101)).thenReturn(dummyOptional);
		Optional<ReviewEntity> actualOptional = reviewService.getAReview(101);
		assertTrue(actualOptional.isPresent());
	}
	
	@Test
	@DisplayName("Test Fetch A Review with non-existing review id")
	public void testGetAReviewNotExists() {
		Optional<ReviewEntity> dummyOptional = Optional.empty();
		when(reviewDao.findById(12345)).thenReturn(dummyOptional);
		Optional<ReviewEntity> actualOptional = reviewService.getAReview(12345);
		assertFalse(actualOptional.isPresent());
	}
}
