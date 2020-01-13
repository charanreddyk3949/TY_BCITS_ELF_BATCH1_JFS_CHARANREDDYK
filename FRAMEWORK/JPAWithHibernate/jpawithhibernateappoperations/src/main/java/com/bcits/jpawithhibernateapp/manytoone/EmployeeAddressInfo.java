package com.bcits.jpawithhibernateapp.manytoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.bcits.jpawithhibernateappinsert.beans.EmployeePrimaryInfo;

import lombok.Data;
@Data
@Entity
@Table(name="employee_address_info")
public class EmployeeAddressInfo implements Serializable{
	@EmbeddedId
	private EmployeeAddressPK addressPK;
	@Column
	private int houseno;
	@Column
	private String address1;
	@Column
	private String address2;
	@Column
	private String landmark;
	@Column
	private String city;
	@Column
	private long pincode;
	
	@MapsId("empid")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empid")
	private EmployeePrimaryInfo primaryInfo;

}
