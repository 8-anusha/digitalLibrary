package com.example.digitalLibrary.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder



public class BorrowRecord {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	//one user can borrow many books
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	//one book can be borrowedd many times
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	private LocalDate borrowDate;
	private LocalDate returnDate;
	private boolean returned;
	
}
