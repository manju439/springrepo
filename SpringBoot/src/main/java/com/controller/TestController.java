package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	public TestController(){
		System.out.println("==========Injecting bean by Spring IOC=========");
	}
	
	@RequestMapping("/hello")
	public String hello(){
		return "Hello World";
	}

}
