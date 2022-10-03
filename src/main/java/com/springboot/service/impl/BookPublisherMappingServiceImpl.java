package com.springboot.service.impl;

import java.lang.module.ResolutionException;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.BookPublisherMapping;
import com.springboot.repository.BookPublisherMappingRepository;
import com.springboot.service.BookPublisherMappingService;



	@Service
	public class BookPublisherMappingServiceImpl implements BookPublisherMappingService {
		
		private BookPublisherMappingRepository bookRepository;
		
		public BookPublisherMappingServiceImpl(BookPublisherMappingRepository bookRepository) {
			super();
			this.bookRepository = bookRepository;
		}

		@Override
		public BookPublisherMapping saveBookPublisherMapping(BookPublisherMapping book) {
			return bookRepository.save(book);
		}

		@Override
		public List<BookPublisherMapping> getAllBooks() {
			return (List<BookPublisherMapping>) bookRepository.findAll;
		}

		@Override
		public BookPublisherMapping getBookById(long bookmappingid) {
		 return bookRepository.findById(bookmappingid).orElseThrow(() ->
			new ResourceNotFoundException("Book","Id",bookmappingid));
		 
		}
		}



