package com.springboot.service;

import java.util.List;

import com.springboot.model.Book;

public interface BookService {
	Book saveBook(Book book);
	List<Book> getAllBooks();
	Book getBookById(long id);
	void deleteBook(long id);


}
