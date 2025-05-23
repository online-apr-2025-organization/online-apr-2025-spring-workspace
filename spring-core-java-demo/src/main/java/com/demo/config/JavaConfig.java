package com.demo.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.demo.beans.Address;
import com.demo.beans.Employee;
import com.demo.beans.Person;

@Configuration
public class JavaConfig {

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Person myPerson() {
		return new Person(201, "Samuel", "John");
	}
	
	@Bean
	public Address myAddress() {
		return new Address(301, "Singapore", "Singapore");
	}
	
	@Bean
	public Employee myEmployee() {
		return new Employee(401, "Anna Smith", myAddress());
	}
}
