package com.project.example.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.example.models.Book;

@Service
public class BookService {
    
    // initialize the books variable with values
	private List<Book> books = new ArrayList<Book>(Arrays.asList(
		new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
		new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180),
		new Book("Moby Dick", "The saga of Captain Ahab", "english", 544),
		new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
		new Book("The Odyssey", "Ancient Greek epic poem", "english", 475)
		));

// returns all the books
public List<Book> allBooks() {
	return books;
}
}