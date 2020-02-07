package com.bcits.discomusecase.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "consumer_support")
public class ConsumerSupportRequest {
	@Id
	@Column(name = "rr_number")
	private String rrNumber;
	@Column
	private String email;
	@Column
	private String text;
	@Column
	private Date date;

}
