package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

	@Data
	@Entity
	@Table(name="BookPublisher")
	public class BookPublisher {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "PUBLISHER_ID",nullable = false)
		private long publisherId;
		
		
		@Column(name="PUBLISHER_NAME")
		private String publisherName;

		public long getPublisherId() {
			return publisherId;
		}

		public void setPublisherId(long publisherId) {
			this.publisherId = publisherId;
		}

		public String getPublisherName() {
			return publisherName;
		}

		public void setPublisherName(String publisherName) {
			this.publisherName = publisherName;
		}

		
		
		
	}


