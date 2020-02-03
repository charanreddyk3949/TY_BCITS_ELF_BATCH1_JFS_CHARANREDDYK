package com.bcits.discomusecase.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class MonthlyConsumptionPK implements Serializable{
	@Column(name = "rr_number")
	private String rrNumber;
	@Column(name = "initial_date")
	private String initialDate;
	

}
