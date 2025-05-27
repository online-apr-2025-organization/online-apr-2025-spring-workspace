package com.pms_spring_rest_data_jpa_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms_spring_rest_data_jpa_project.dao.ReviewDao;
import com.pms_spring_rest_data_jpa_project.dao.entity.ReviewEntity;

@Service
public class ReviewService {
	@Autowired
	ReviewDao reviewDao;
	
	public List<ReviewEntity> getAllReviews(){
		return reviewDao.findAll();
	}
	
	public Optional<ReviewEntity> getAReview(int reviewId) {
		return reviewDao.findById(reviewId);
	}
	
	public ReviewEntity addReview(ReviewEntity newReview) {
		return reviewDao.saveAndFlush(newReview);
	}
	
	public ReviewEntity updateReview(ReviewEntity editReview) {
		return reviewDao.saveAndFlush(editReview);
	}
	
	public void deleteReview(int reviewId) {
		reviewDao.deleteById(reviewId);
	}
}
