package com.example.digitalLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.digitalLibrary.entities.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	List<Book> findByCategoryIgnoreCase(String category);
	List<Book> findByTitleContainingIgnoreCase(String keyword);
	List<Book> findByAuthorIgnoreCase(String author);
	Optional<Book> findByIsbn(String keyword);
}
