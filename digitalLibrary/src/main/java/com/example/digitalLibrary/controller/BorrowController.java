package com.example.digitalLibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.digitalLibrary.entities.BorrowRecord;
import com.example.digitalLibrary.service.BorrowService;

@RestController
@RequestMapping("api/v1/borrow")
public class BorrowController {
	
	@Autowired
	BorrowService borrowService;
	
	@PostMapping("/{bookId}/user/{userId}")
	public void borrowBook(@PathVariable(name="bookId") int bookId, @PathVariable int userId) {
		
		borrowService.borrowBook(bookId, userId);
		
		
	}
	
	@PostMapping("return/{bookId}/user/{userId}")
	public void returnBook(@PathVariable(name="bookId") int bookId,@PathVariable int userId) {
		
		borrowService.returnBook(bookId, userId);
	}
	
	@GetMapping("/history/{userId}") // shud return list
	public void getBorrowHistory(@PathVariable int userId){
		
		borrowService.getBorrowHistory(userId);
	}
	
}
