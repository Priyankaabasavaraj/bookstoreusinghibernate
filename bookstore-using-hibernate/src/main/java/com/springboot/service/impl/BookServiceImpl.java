package com.springboot.service.impl;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.Book;
import com.springboot.repository.BookRepository;
import com.springboot.service.BookService;


@Service
public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}


	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}


	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	@Override
	public Book getBookById(long id) {
//		Optional<Book> book = bookRepository.findById(id);
//		if(book.isPresent()) {
//			return book.get();
//		}
//		else {
//			throw new ResolutionException("Book","Id",id);
//		}
		return bookRepository.findById(id).orElseThrow(() ->
					new ResourceNotFoundException("Book","Id",id));	
	}

//	@Override
//	public Book getBookByBookName(String book_name) {
//		return bookRepository.findByBookName(book_name).orElseThrow(() ->
//		new ResourceNotFoundException("Book","BookName",book_name));
//	}

	@Override
	public void deleteBook(long id) {
		
		// check whether a book id exist in a DB or not
		bookRepository.findById(id).orElseThrow(() ->
							new ResourceNotFoundException("Book","Id",id));
		bookRepository.deleteById(id);
		
	}

}



