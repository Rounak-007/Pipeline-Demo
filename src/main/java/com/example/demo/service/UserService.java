package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.User;

public interface UserService {
	
User createUser(User user);
	
	List<User> getAllUsers();
	
	User getUser(Long userId);
	
	public ResponseEntity<User> updateUser(Long userId, User updatedUser);
	
	public ResponseEntity<String> deleteUser(Long userId);

}
