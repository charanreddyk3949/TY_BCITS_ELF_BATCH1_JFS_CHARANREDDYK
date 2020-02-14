package com.bcits.discomusecase.beans;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "consumer_support")
public class ConsumerSupportRequest {
	
	@EmbeddedId
	private ConsumerSupportRequestPK consumerSupportRequestPK;
	@Column
	private String email;
	@Column
	private String text;
	@Column
    private	String region;
	@Column
	private String response;
	
	
	public ConsumerSupportRequestPK getConsumerSupportRequestPK() {
		return consumerSupportRequestPK;
	}
	public void setConsumerSupportRequestPK(ConsumerSupportRequestPK consumerSupportRequestPK) {
		this.consumerSupportRequestPK = consumerSupportRequestPK;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	

}
