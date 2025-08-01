package com.example.digitalLibrary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.digitalLibrary.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	Optional<User> findByEmail(String email);

}
