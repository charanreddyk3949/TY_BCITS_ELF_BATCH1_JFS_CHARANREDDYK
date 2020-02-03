package com.bcits.discomusecase.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//@Data
@Entity
@Table(name="monthly_consumption")
public class MonthlyConsumption implements Serializable {
	
	@EmbeddedId
	private MonthlyConsumptionPK MonthlyConsumption;
	
	@Column(name = "final_date")
	private Date finalDate;
	@Column(name="initial_reading")
	private Double initialReading;
	@Column(name="final_reading")
	private Double finalReading;
	
	@Column(name = "consumption_units")
	private int consumptionUnits;
	
	
	public MonthlyConsumptionPK getMonthlyConsumption() {
		return MonthlyConsumption;
	}
	public void setMonthlyConsumption(MonthlyConsumptionPK monthlyConsumption) {
		MonthlyConsumption = monthlyConsumption;
	}
	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
	public Double getInitialReading() {
		return initialReading;
	}
	public void setInitialReading(Double initialReading) {
		this.initialReading = initialReading;
	}
	
	public int getConsumptionUnits() {
		return consumptionUnits;
	}
	public void setConsumptionUnits(int consumptionUnits) {
		this.consumptionUnits = consumptionUnits;
	}
	
	public Double getFinalReading() {
		return finalReading;
	}
	public void setFinalReading(Double finalReading) {
		this.finalReading = finalReading;
	}
	
	
	
}
