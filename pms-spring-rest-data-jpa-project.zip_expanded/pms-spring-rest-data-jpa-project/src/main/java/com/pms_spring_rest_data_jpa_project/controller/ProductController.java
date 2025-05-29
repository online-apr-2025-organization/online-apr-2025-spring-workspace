package com.pms_spring_rest_data_jpa_project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms_spring_rest_data_jpa_project.dao.entity.ProductEntity;
import com.pms_spring_rest_data_jpa_project.exception.ProductNotFoundException;
import com.pms_spring_rest_data_jpa_project.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductEntity>> getAllProducts(){
		List<ProductEntity> responseBody = productService.getAllProducts();
		return new ResponseEntity<List<ProductEntity>>(responseBody, HttpStatus.OK);
	}
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<ProductEntity> getAProduct(@PathVariable int productId) {
		ProductEntity prod = null;
		Optional<ProductEntity> optProduct = productService.getAProduct(productId);
		if(optProduct.isPresent()){
			prod = optProduct.get();
		}else {
			throw new ProductNotFoundException();
		}
		return new ResponseEntity<ProductEntity>(prod, HttpStatus.OK);
	}
	
	@GetMapping("/products/category/{pCat}")
	public ResponseEntity<List<ProductEntity>> getProductsByCategory(@PathVariable("pCat") String category){
		List<ProductEntity> responseBody = productService.getProductsByCategory(category);
		return new ResponseEntity<List<ProductEntity>>(responseBody, HttpStatus.OK);
	}
	
	@PostMapping("/products")
	public ResponseEntity<ProductEntity> addProduct(@RequestBody @Valid ProductEntity newProduct) {
		return new ResponseEntity<ProductEntity>(productService.addProduct(newProduct), HttpStatus.OK);
	}
	
	@PutMapping("/products")
	public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductEntity editProduct) {
		return new ResponseEntity<ProductEntity>(productService.updateProduct(editProduct), HttpStatus.OK);
	}
	
	@DeleteMapping("/products")
	public ResponseEntity<Void> deleteProduct(int productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
