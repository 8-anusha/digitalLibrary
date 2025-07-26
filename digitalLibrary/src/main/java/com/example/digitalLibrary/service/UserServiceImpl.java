package com.example.digitalLibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalLibrary.DTOs.UserRegisterRequest;
import com.example.digitalLibrary.entities.User;
import com.example.digitalLibrary.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public void register(UserRegisterRequest request) {
		if(userRepo.findByEmail(request.getEmail()).isPresent()) {
			throw new RuntimeException("email is already registered");
		}
		User user= new User().builder().name(request.getName()).email(request.getEmail()).password(request.getPassword()).role("USER").build();
		userRepo.save(user);
		

	}

	@Override
	public User login(String email, String password) {
		
		return userRepo.findByEmail(email).filter(u-> u.getPassword().equals(password)).orElseThrow(()->new RuntimeException("Invalid credentials"));

	}

}
