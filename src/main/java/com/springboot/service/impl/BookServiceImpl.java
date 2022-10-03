package com.springboot.service.impl;

import java.awt.print.Pageable;
import java.lang.module.ResolutionException;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
		return (List<Book>) bookRepository.findAll();
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

	@Override
	public void deleteBook(long id) {
		
		// check whether a book id exist in a DB or not
		bookRepository.findById(id).orElseThrow(() ->
							new ResourceNotFoundException("Book","Id",id));
		bookRepository.deleteById(id);
		
	}

//	@Override
//	public List<Book> findPaginated(int pageNo, int pageSize) {
//		Pageable paging=PageRequest.of(pageNo-1, pageSize);
//		Page<Book> pageResult=bookRepository.findAll(paging);
//		return pageResult.toList();
//	}
//
//
//	@Override
//	public List<Book> findBookSortAsc(String name) {
//		
//		return bookRepository.findAll(org.framework.data.domain.sort.by(org.springframework.data.domain);;
//	}
//
//
//	@Override
//	public List<Book> findBookSortDsc(String name) {
//	
//		return bookRepository.findAll(org.framework.data.domain.sort.by(org.springframework.data.domain);
//	}
}

