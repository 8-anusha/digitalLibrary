package com.example.digitalLibrary.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digitalLibrary.entities.Book;
import com.example.digitalLibrary.entities.BorrowRecord;
import com.example.digitalLibrary.entities.User;
import com.example.digitalLibrary.repository.BookRepository;
import com.example.digitalLibrary.repository.BorrowRecordRepository;
import com.example.digitalLibrary.repository.UserRepository;
import com.example.digitalLibrary.util.BookNotFoundException;

@Service
public class BorrowServiceImpl implements BorrowService {
	
	@Autowired
	private BorrowRecordRepository borrowRecordRepo;
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private UserRepository userRepo;
	

	@Override
	public void borrowBook(int bookId, int userId) {
		Book book = bookRepo.findById(bookId).orElseThrow(()-> new BookNotFoundException("book not found with id :"+ bookId));
		if( !book.isAvailable()) {
			
			throw new RuntimeException("Book is already borrowed");	
		}
		User user= userRepo.findById(userId).orElseThrow(()->new RuntimeException("user not found with id: "+userId));
		
		BorrowRecord record = new BorrowRecord().builder().book(book).user(user).borrowDate(LocalDate.now()).returned(false).build();
		book.setAvailable(false);
		borrowRecordRepo.save(record);
		bookRepo.save(book);
		
		 

	}

	@Override
	public void returnBook(int bookId, int userId) {
		
		BorrowRecord record= borrowRecordRepo.findByBookIdAndReturnedFalse(bookId).orElseThrow(()-> new RuntimeException("Borrow record not found"));
		if(!(record.getUser().getId()==userId)) {
			throw new RuntimeException("this book was not borrowed by this user");
			
		}
		record.setReturnDate(LocalDate.now());
		record.setReturned(true);
		
		Book book= record.getBook();
		book.setAvailable(true);
		
		borrowRecordRepo.save(record);
		bookRepo.save(book);
		

	}

	@Override
	public List<BorrowRecord> getBorrowHistory(int userId) {
		
		
		//User user= userRepo.findById(userId).orElseThrow(()->new RuntimeException("user not found with id: "+userId));

		return borrowRecordRepo.findByUserId(userId);
	}

}
