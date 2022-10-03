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

import com.springboot.model.BookPublisherMapping;
import com.springboot.service.BookPublisherMappingService;



	
	
	@RestController
	@RequestMapping("/api/BOOKSPUBLISHERMAPPING")
	public class BookPublisherMappingController {

		private BookPublisherMappingService bookService;

		public BookPublisherMappingController(BookPublisherMappingService bookService) {
			super();
			this.bookService = bookService;
		}

		// build create book REST API
		@PostMapping()
		public ResponseEntity<BookPublisherMapping> saveBook(@RequestBody BookPublisherMapping book) {
			return new ResponseEntity<BookPublisherMapping>(bookService.saveBookPublisherMapping(book),HttpStatus.CREATED);
			
		}
		
		// build get all book REST API
		@GetMapping
		public List<BookPublisherMapping> getAllBooks(){
			return bookService.getAllBooks();
		}
		
		// build get book by id RRST API
		// http://localhost:8080/api/books/1
		@GetMapping("{bookmappingid}")
		public ResponseEntity<BookPublisherMapping> getBookById(@PathVariable("bookmappingid") long bookmappingid){
			return new ResponseEntity<BookPublisherMapping>(bookService.getBookById(bookmappingid), HttpStatus.OK);
			
		}

	} 



