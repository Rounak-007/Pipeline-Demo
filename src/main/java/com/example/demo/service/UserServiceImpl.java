package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(Long userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found with ID: "+userId));
	}

	@Override
	public ResponseEntity<User> updateUser(Long userId, User updatedUser) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			User existingCustomer = optionalUser.get();
			existingCustomer.setName(updatedUser.getName());
			existingCustomer.setPhoneNumber(updatedUser.getPhoneNumber());
			return new ResponseEntity<>(userRepository.save(existingCustomer), HttpStatus.OK);
		} 
		else {
			throw new RuntimeException("User not found with ID: " + userId);
		}
	}

	@Override
	public ResponseEntity<String> deleteUser(Long userId) {
		// TODO Auto-generated method stub
		userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found with ID: "+userId));
		userRepository.deleteById(userId);
		return new ResponseEntity<>("Customer Deleted successfully",HttpStatus.OK);
	}

}
