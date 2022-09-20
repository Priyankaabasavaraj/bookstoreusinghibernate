package com.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {


}
