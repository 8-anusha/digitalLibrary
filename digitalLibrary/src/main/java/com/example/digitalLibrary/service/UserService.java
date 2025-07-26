package com.example.digitalLibrary.service;

import com.example.digitalLibrary.DTOs.UserRegisterRequest;
import com.example.digitalLibrary.entities.User;

public interface UserService {
	void register(UserRegisterRequest request);
	User login(String email, String password);
	

}
