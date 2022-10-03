package com.springboot.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.BookPublisher;
import com.springboot.service.BookPublisherService;

@RestController
@RequestMapping("/api/BOOKSPUBLISHER")
public class BookPublisherController {

	private BookPublisherService bookService;

	public BookPublisherController(BookPublisherService bookService) {
		super();
		this.bookService = bookService;
	}

	// build create book REST API
	@PostMapping()
	public ResponseEntity<BookPublisher> saveBookPublisher(@RequestBody BookPublisher book) {
		return new ResponseEntity<BookPublisher>(bookService.saveBookPublisher(book),HttpStatus.CREATED);
		
	}
	
	// build get all book REST API
	@GetMapping
	public List<BookPublisher> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	// build get book by id RRST API
	// http://localhost:8080/api/books/1
	@GetMapping("{publisherId}")
	public ResponseEntity<BookPublisher> getBookByPublisherId(@PathVariable("publisherId") long publisherId){
		return new ResponseEntity<BookPublisher>(bookService.getBookByPublisherId(publisherId), HttpStatus.OK);
		
	}

} 

