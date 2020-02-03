package com.bcits.discomusecase.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="payment_details")
public class PaymentDetails {
	@Id
    @Column(name = "rr_number")
	private String rrNumber;
	@Column(name = "txn_number")
	private int txnNumber;
    @Column(name = "txn_date")    
	private Date txnDate;
    @Column(name = "txn_type")
	private String txnType;
    @Column(name="amt_paid")
	private Double amtPaid;
    @Column(name = "txn_amount")
	private Double txnAmount;
    @Column(name = "txn_status")
	private String txnStatus;

	
	
    public String getRrNumber() {
		return rrNumber;
	}
	public void setRrNumber(String rrNumber) {
		this.rrNumber = rrNumber;
	}
	public int getTxnNumber() {
		return txnNumber;
	}
	public void setTxnNumber(int txnNumber) {
		this.txnNumber = txnNumber;
	}
	public Date getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public Double getAmtPaid() {
		return amtPaid;
	}
	public void setAmtPaid(Double amtPaid) {
		this.amtPaid = amtPaid;
	}
	public Double getTxnAmount() {
		return txnAmount;
	}
	public void setTxnAmount(Double txnAmount) {
		this.txnAmount = txnAmount;
	}
	public String getTxnStatus() {
		return txnStatus;
	}
	public void setTxnStatus(String txnStatus) {
		this.txnStatus = txnStatus;
	}
	
}
