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
@Table(name="bill_history")
public class BillHistory implements Serializable{
	
    @EmbeddedId
	private BillHistoryPK billHistoryPK;
	
	@Column(name="bill_amount")
	private Double billAmount;
	@Column
	private String region;
	@Column(name="units_consumed")
	private int unitsConsumed;
	
	public BillHistoryPK getBillHistoryPK() {
		return billHistoryPK;
	}
	public void setBillHistoryPK(BillHistoryPK billHistoryPK) {
		this.billHistoryPK = billHistoryPK;
	}
	
	public Double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getUnitsConsumed() {
		return unitsConsumed;
	}
	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}
	

}
