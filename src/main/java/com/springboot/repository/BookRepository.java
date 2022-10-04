package com.springboot.repository;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.springboot.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>,JpaSpecificationExecutor<Book>{
	Page<Book> findAll(Specification<Book> spec, Pageable page);

}
