package com.bcits.discomusecase.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "consumption_history")
public class ConsumptionHistory {
    
	@Id
	@Column(name = "rr_number")
	private String rrNumber;
	@Column(name = "read_date")
	private Date readDate;
	@Column
	private Double consumption;
}
