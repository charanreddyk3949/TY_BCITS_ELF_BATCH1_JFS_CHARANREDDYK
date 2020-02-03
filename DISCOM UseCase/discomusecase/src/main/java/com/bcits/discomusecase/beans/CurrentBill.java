package com.bcits.discomusecase.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="current_bill")
public class CurrentBill implements Serializable {
	
	@Id
	@Column(name="rr_number")
	private String rrNumber;
	@Column(name="initial_reading")
	private Double initialReading;
	@Column(name="present_reading")
	private Double presentReading;
	@Column(name="due_date")
	private Date dueDate;
	@Column(name="bill_amount")
	private Double billAmount;
	@Column
	private int consumption;
	
	
	public String getRrNumber() {
		return rrNumber;
	}
	public void setRrNumber(String rrNumber) {
		this.rrNumber = rrNumber;
	}
	public Double getInitialReading() {
		return initialReading;
	}
	public void setInitialReading(Double initialReading) {
		this.initialReading = initialReading;
	}
	public Double getPresentReading() {
		return presentReading;
	}
	public void setPresentReading(Double presentReading) {
		this.presentReading = presentReading;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}
	public int getConsumption() {
		return consumption;
	}
	public void setConsumption(int consumption) {
		this.consumption = consumption;
	}
	
	
	
	
	
		
	
}
