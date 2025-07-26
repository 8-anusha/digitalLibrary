package com.example.digitalLibrary.service;

import java.util.List;

import com.example.digitalLibrary.DTOs.BookDTO;
import com.example.digitalLibrary.entities.Book;


public interface BookService {
	
	List<Book> getAllBooks();
	Book addBook(BookDTO bookDTO);
	String deleteBook(int id);
	Book  updateBook(int id, BookDTO bookDTO);
	List<Book> searchBooks(String title, String author, String isbn, String category);
}
