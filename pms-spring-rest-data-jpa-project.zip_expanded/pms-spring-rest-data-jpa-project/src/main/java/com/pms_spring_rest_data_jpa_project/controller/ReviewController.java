package com.pms_spring_rest_data_jpa_project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms_spring_rest_data_jpa_project.dao.entity.ReviewEntity;
import com.pms_spring_rest_data_jpa_project.service.ReviewService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/reviews")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")
	public ResponseEntity<List<ReviewEntity>> getAllReviews(){
		List<ReviewEntity> responseBody = reviewService.getAllReviews();
		return new ResponseEntity<List<ReviewEntity>>(responseBody, HttpStatus.OK);
	}
	
	@GetMapping("/reviews/{reviewId}")
	@PreAuthorize("hasAuthority('USER')")
	public ResponseEntity<Optional<ReviewEntity>> getAReview(@PathVariable int reviewId) {
		return new ResponseEntity<Optional<ReviewEntity>>(reviewService.getAReview(reviewId), HttpStatus.OK);
	}
	
	@PostMapping("/reviews")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<ReviewEntity> addReview(@RequestBody ReviewEntity newReview) {
		return new ResponseEntity<ReviewEntity>(reviewService.addReview(newReview), HttpStatus.OK);
	}
	
	@PutMapping("/reviews")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<ReviewEntity> updateReview(@RequestBody ReviewEntity editReview) {
		return new ResponseEntity<ReviewEntity>(reviewService.updateReview(editReview), HttpStatus.OK);
	}
	
	@DeleteMapping("/reviews")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Void> deleteReview(int reviewId) {
		reviewService.deleteReview(reviewId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
