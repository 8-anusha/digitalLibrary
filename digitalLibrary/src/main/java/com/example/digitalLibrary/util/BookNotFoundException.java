package com.example.digitalLibrary.util;

public class BookNotFoundException extends RuntimeException {
	public BookNotFoundException(String message) {
		super(message); 
	}

}
