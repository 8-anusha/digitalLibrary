package com.example.digitalLibrary.DTOs;

import jakarta.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class BookDTO {
	@NotBlank(message="title cant be empty")
	public String title;
	
	@NotBlank(message="author cant be empty")
	public String author;
	
	@NotBlank(message="isbn cant be empty")
	public String isbn;
	
	@NotBlank(message="category cant be empty")
	public  String category;
	
}
