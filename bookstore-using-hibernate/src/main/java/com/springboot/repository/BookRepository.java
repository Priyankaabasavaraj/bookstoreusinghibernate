package com.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.springboot.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {


}
