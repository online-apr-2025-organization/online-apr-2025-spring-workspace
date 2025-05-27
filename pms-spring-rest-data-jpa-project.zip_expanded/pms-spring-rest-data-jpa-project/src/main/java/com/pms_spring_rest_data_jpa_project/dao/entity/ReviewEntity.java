package com.pms_spring_rest_data_jpa_project.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="review_details")
public class ReviewEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="review_id")
	private int reviewId;
	
	@Column(name="review_rating")
	private int reviewRating;
	
	@Column(name="review_description")
	private String reviewDescription;
	
//	@Column(name="review_product_id")
//	private int reviewProductId;
	
	@ManyToOne
	@JoinColumn(name="review_product_id")
	private ProductEntity productEntity;
}
