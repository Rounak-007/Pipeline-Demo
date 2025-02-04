package com.example.demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/home")
	public String home() {
		return "User Home Page working!!!";
	}
	
	@GetMapping("/test")
	public String test(@RequestParam String id) {
		return "Test ID: "+id;
	}
	
	@GetMapping("/demo")
	public Map<String, Object> getValues(){
		Map<String, Object> data=new HashMap<>();
		data.put("message", "Java API is running");
		data.put("Languages", Arrays.asList("Java","Python","Javascript"));
		data.put("code", 1234);
		return data;
	}
}
