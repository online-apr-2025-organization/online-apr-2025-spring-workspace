package com.pms_spring_rest_data_jpa_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms_spring_rest_data_jpa_project.dao.ProductDao;
import com.pms_spring_rest_data_jpa_project.dao.entity.ProductEntity;

@Service
public class ProductService {
	@Autowired
	ProductDao productDao;
	
	public List<ProductEntity> getAllProducts(){
		return productDao.findAll();
	}
	
	public Optional<ProductEntity> getAProduct(int productId) {
		return productDao.findById(productId);
	}
	
	public List<ProductEntity> getProductsByCategory(String category){
		return productDao.findByProductCategory(category);
	}
	
	public ProductEntity addProduct(ProductEntity newProduct) {
		return productDao.saveAndFlush(newProduct);
	}
	
	public ProductEntity updateProduct(ProductEntity editProduct) {
		return productDao.saveAndFlush(editProduct);
	}
	
	public void deleteProduct(int productId) {
		productDao.deleteById(productId);
	}
}
