package com.demo.spring_rest_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloRestController {

	// lets create the endpoints here - endpoints are urls mapped to a method here
	
	// Get endpoint
	// http://localhost:7788/api/wish
	@GetMapping("/wish")
	public String wishAll() {
		return "Hello everyone! Have a wonderful day!!";
	}
}
