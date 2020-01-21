package com.bcits.bcitsusecase.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="consumer_master")
public class ConsumersMaster implements Serializable{
	
	@Id
	@Column(name="meter_number")
	private String meterNumber;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column
	private String email;
	@Column
	private String address1;
	@Column
	private String address2;
	@Column
	private String city;
	@Column
	private String state;
	@Column(name="pin_code")
	private long pinCode;
	@Column
	private String region;
	@Column(name="consumer_type")
	private String consumerType;
	@Column
	private String password;
	@Column(name="confirm_password")
	private String confirmPassword;
	
	

}
