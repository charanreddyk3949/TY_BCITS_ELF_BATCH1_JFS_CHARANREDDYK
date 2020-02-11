package com.bcits.discomusecase.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "admin_info")
public class AdminBean {

	@Id
	@Column(name= "admin_id")
	private int adminId;
	@Column
	private String name;
	@Column
	private String password;
}//End of class
