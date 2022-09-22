package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

	@Data
	@Entity
	@Table(name="BookPublisherMapping")
	
public class BookPublisherMapping {
		@Column(name="PUBLISHER_ID")
		private long publisherId;
		
		@Column(name="BOOK_ID")
		private long id;

		public long getPublisherId() {
			return publisherId;
		}

		public void setPublisherId(long publisherId) {
			this.publisherId = publisherId;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}
		
		
		
}
