package com.pms_spring_rest_data_jpa_project.dao.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="order_details")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="order_date")
	private LocalDate orderDate;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="product_order_details", 
				joinColumns = @JoinColumn(name="order_id"),
				inverseJoinColumns = @JoinColumn(name="product_id"))
	private List<ProductEntity> allProducts;
}
