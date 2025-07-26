package com.example.digitalLibrary.service;

import java.util.List;

import com.example.digitalLibrary.entities.BorrowRecord;


public interface BorrowService {
	void borrowBook(int bookId,int userId);
	void returnBook(int bookId,int userId);
	List<BorrowRecord> getBorrowHistory(int userId);
}
