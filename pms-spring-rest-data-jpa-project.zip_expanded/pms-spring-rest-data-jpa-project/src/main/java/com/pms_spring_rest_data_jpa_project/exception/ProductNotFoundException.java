package com.pms_spring_rest_data_jpa_project.exception;

public class ProductNotFoundException extends RuntimeException{

	@Override
	public String getMessage() {
		return "Product not found! Please try with another ID!";
	}
}
