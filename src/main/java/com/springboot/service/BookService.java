package com.springboot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.springboot.model.Book;
import com.springboot.model.Pagination;

public interface BookService {
	public Pagination<Book> findAllBook( Specification<Book> spec,Pageable pageable);
	Book saveBook(Book book);
	List<Book> getAllBooks();
	Book getBookById(long id);
	void deleteBook(long id);
//
//public List<Book> findPaginated(int pageNo, int pageSize);
//public List<Book> findBookSortAsc(String name);
//public List<Book> findBookSortDsc(String name);

}
