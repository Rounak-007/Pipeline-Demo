package com.example.demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
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
	
	@PostMapping("/create")
	public User createUser(@RequestBody User customer) {
		//TODO: process POST request
		return userService.createUser(customer);
	}

	@GetMapping("/list")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

	@GetMapping("/{userId}")
	public User getUser(@PathVariable Long userId) {
		return userService.getUser(userId);
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
		return userService.updateUser(userId, updatedUser);
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId) {
		//TODO: process DELETE request
		return userService.deleteUser(Long.parseLong(userId));
	}
}
