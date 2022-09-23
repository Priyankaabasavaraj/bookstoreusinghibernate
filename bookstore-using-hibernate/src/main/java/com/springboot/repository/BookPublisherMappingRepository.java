package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.BookPublisherMapping;
@Repository
public interface BookPublisherMappingRepository extends CrudRepository<BookPublisherMapping, Long>{

}
