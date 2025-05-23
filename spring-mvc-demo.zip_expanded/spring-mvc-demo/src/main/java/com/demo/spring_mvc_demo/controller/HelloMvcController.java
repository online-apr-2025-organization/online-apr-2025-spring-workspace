package com.demo.spring_mvc_demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloMvcController {

	@Value("${spring.application.name}")
	String applicationName;
	
	// http://localhost:6069/helloworld
	@RequestMapping("/helloworld")
	public String sayHello() {
		System.out.println("in sayHello");
		return "hello";
	}
	
	// http://localhost:6069/greet
	@RequestMapping("/greet")
	public String greetings(Model model) {
		model.addAttribute("appName", applicationName);
		return "greeting";
	}
}
