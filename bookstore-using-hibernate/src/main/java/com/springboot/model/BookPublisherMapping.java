package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

	
@Data
@Entity
@Table(name="BookPublisherMapping")	
public class BookPublisherMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_PUBLISHER_ID",nullable = false)
	private long bookmappingid;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PUBLISHER_ID",nullable=false)
		private BookPublisher publisherId;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="BOOK_ID",nullable=false)
		private Book id;

	public long getBookmappingid() {
		return bookmappingid;
	}

	public void setBookmappingid(long bookmappingid) {
		this.bookmappingid = bookmappingid;
	}

	public BookPublisher getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(BookPublisher publisherId) {
		this.publisherId = publisherId;
	}

	public Book getId() {
		return id;
	}

	public void setId(Book id) {
		this.id = id;
	}

		
		
}
