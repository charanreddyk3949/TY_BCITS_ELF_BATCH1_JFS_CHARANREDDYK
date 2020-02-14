package com.bcits.discomusecase.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;


@Data
@Embeddable
public class ConsumerSupportRequestPK implements Serializable {
	
	@Column(name = "rr_number")
	private String rrNumber;
	@Column
	private Date date;
	
	public String getRrNumber() {
		return rrNumber;
	}
	public void setRrNumber(String rrNumber) {
		this.rrNumber = rrNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
