package com.pms_spring_rest_data_jpa_project.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="product_details")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="prod_id")
	private int productId;
	
	@Column(name="prod_name")
	private String productName;
	
	@Column(name="prod_description")
	private String productDescription;
	
	@Column(name="prod_cost")
	private int productCost;
	
	@Column(name="prod_category")
	private String productCategory;
	
	@Column(name="prod_image_url")
	private String productImageUrl;
}
