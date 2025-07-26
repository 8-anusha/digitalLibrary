package com.example.digitalLibrary.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginDTO {
	
	@NotBlank(message="Email is required")
	@Email(message="Invalid email format")
	private String email;
	

	@NotBlank(message="Password is required")
	@Size(min=8,message="password must be 8 characters long")//add a custom validation
	private String password;
	

}
