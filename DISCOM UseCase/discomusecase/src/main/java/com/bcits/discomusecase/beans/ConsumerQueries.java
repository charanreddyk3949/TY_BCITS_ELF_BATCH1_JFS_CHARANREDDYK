package com.bcits.discomusecase.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
@Data
@Table(name="consumer_queries")
public class ConsumerQueries {
	
	   @Column(name = "rr_number")
	   private String rrNumber;
	   @Column
	   private String email;
	   @Column
	   private String comments;
	
	
   public String getRrNumber() {
		return rrNumber;
	}
	public void setRrNumber(String rrNumber) {
		this.rrNumber = rrNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

}
