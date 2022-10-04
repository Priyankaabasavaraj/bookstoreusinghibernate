package com.springboot.controller;




import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Book;
import com.springboot.model.Pagination;
import com.springboot.service.BookService;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

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
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/book/page")
		    public Pagination<Book> getBook(
		            @RequestParam(value = "BOOK_ID", required =false) long id,
		            @RequestParam(value = "BOOK_Name", required = false) String bookName,
		            @RequestParam(value = "date", required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") Date holidayDate,
		            @RequestParam(value = "keyword", required = false) String keyword,
		            @RequestParam(value = "page", defaultValue = "1", required = false) int page,
		            @RequestParam(value = "size", defaultValue = "0", required = false) int size,
		            @RequestParam(value = "sort", defaultValue = "createdDate", required = false) String sort,
		            @RequestParam(value = "order", defaultValue = "desc", required = false) String order,
		            @And({ 
		                @Spec(path = "id", params = "bookId", spec = Equal.class),
		                @Spec(path = "bookName", params = "bookName", spec = Equal.class),
		                @Spec(path = "bookDate", params = "bookDate", spec = Equal.class)}) 
		            Specification<Book> spec) {

		        Pageable pageable = (size != 0
		                ? PageRequest.of(page - 1, size,order.trim().equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,sort)
		                : Pageable.unpaged());
		        return bookService.findAllBook(spec,pageable);
		    }
} 


