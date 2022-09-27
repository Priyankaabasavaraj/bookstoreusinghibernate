package com.springboot.service;

import java.util.List;

import com.springboot.model.BookPublisherMapping;



public interface BookPublisherMappingService {
	BookPublisherMapping saveBookPublisherMapping(BookPublisherMapping book);
	List<BookPublisherMapping> getAllBooks();
	BookPublisherMapping getBookById(long bookmappingid);
}
