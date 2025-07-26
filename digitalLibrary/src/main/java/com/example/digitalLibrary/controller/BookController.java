package com.example.digitalLibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.digitalLibrary.DTOs.BookDTO;
import com.example.digitalLibrary.entities.Book;
import com.example.digitalLibrary.service.BookService;
import com.example.digitalLibrary.util.BookNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	

	@GetMapping
	public ResponseEntity< List<Book>> getAllBooks() {
		
		return new ResponseEntity< List<Book> >( bookService.getAllBooks(),HttpStatus.OK);
	}

	@PostMapping
	public Book addBook(@RequestBody @Valid BookDTO bookDTO) {
		
		return bookService.addBook(bookDTO);
	}

//	@PutMapping("/{id}")
//	public ResponseEntity<Book>updateBook(@PathVariable int id, @RequestBody BookDTO bookDTO) {
//		Book b= bookService.updateBook(id, bookDTO);
//		return ResponseEntity.ok(b);
//	}
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable int id) {
		
		return bookService.deleteBook(id);

	}
	
	@GetMapping("/search")
	public List<Book> searchBooks(
			@RequestParam(required=false) String title, 
			@RequestParam(required=false) String author,
			@RequestParam(required=false) String isbn, 
			@RequestParam(required=false) String category
			)
	{
		
		return bookService.searchBooks(title, author, isbn, category);
	}
	

}
