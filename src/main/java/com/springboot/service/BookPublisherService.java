package com.springboot.service;

import java.util.List;

import com.springboot.model.BookPublisher;



public interface BookPublisherService {
	
	public interface BookService {
		BookPublisher saveBookPublisher(BookPublisher book);
		List<BookPublisher> getAllBooks();
		BookPublisher getBookByPublisherId(long publisherId);

	}

	public BookPublisher saveBookPublisher(BookPublisher book);

	public List<BookPublisher> getAllBooks();

	public BookPublisher getBookByPublisherId(long publisherId);

}
