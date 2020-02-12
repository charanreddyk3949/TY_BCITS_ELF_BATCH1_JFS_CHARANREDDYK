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
	

}
