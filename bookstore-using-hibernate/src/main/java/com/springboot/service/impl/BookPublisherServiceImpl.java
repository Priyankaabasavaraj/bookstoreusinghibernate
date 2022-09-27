package com.springboot.service.impl;

import java.lang.module.ResolutionException;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.BookPublisher;
import com.springboot.model.BookPublisherMapping;
import com.springboot.repository.BookPublisherRepository;

import com.springboot.service.BookPublisherService;



@Service
public class BookPublisherServiceImpl implements BookPublisherService {
	
	private BookPublisherRepository bookRepository;

	public BookPublisherServiceImpl(BookPublisherRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

public BookPublisher saveBookPublisher(BookPublisher book) {
	return bookRepository.save(book);
}

@Override
public List<BookPublisher> getAllBooks() {
	
	return (List<BookPublisher>) bookRepository.findAll();
}

@Override
public BookPublisher getBookByPublisherId(long publisherId) {
	
	return bookRepository.findById(publisherId).orElseThrow(() ->
	new ResourceNotFoundException("Book","Id",publisherId));
}


}
	
