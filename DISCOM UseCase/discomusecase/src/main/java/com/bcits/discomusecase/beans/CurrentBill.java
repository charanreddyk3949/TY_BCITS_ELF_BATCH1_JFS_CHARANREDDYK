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
	@Column(name="total_units")
	private Double totalUnits;
	@Column(name="due_date")
	private Date dueDate;
	
//	@MapsId
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="meterNumber")
//	private ConsumersMasterBean consumerMaster;
//	
	
	
}
