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

import com.springboot.model.Book;
import com.springboot.service.BookService;

@RestController
@RequestMapping("/api/BOOKS")
public class BookController {
	
	private BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	// build create book REST API
	@PostMapping()
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(bookService.saveBook(book),HttpStatus.CREATED);
		
	}
	
	// build get all book REST API
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	// build get book by id RRST API
	// http://localhost:8080/api/books/1
	@GetMapping("{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") long id){
		return new ResponseEntity<Book>(bookService.getBookById(id), HttpStatus.OK);
		
	}
	
//	// build get book by book name RRST API
//	@GetMapping("{book_name}")
//	public ResponseEntity<Book> getBookByBookName(@PathVariable("book_name") String book_name){
//		return new ResponseEntity<Book>(bookService.getBookByBookName(book_name), HttpStatus.OK);
//	}
	
	// build delete book RRST API
	// http://localhost:8080/api/books/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") long id){
		
		// delete book from DB
		bookService.deleteBook(id);
		return new ResponseEntity<String>("Book solded successfully!.", HttpStatus.OK);
	}
	
	// build get book by book name REST API
} 


