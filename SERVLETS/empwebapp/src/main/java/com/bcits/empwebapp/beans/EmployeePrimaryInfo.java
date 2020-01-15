package com.bcits.empwebapp.beans;



import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee_primary_info")
public class EmployeePrimaryInfo implements Serializable{
    @Id
	@Column(name="emp_id")
	private int empId;
	@Column
	private String name;
	@Column(name="mobile_no")
	private long mobileNo;
	@Column(name="official_mail")
	private String officialMailid;
	@Column(name="dob")
	private Date dateOfBirth;
	@Column(name="doj")
	private Date dateOfJoining;
	@Column
	private String designation;
	@Column(name="blood_group")
	private String bloodGroup;
	@Column
	private int salary;
	@Column(name="dept_id")
	private int deptId;
	@Column(name="manager_id")
	private int managerId;
	@Column
	private String password;
	
	
}
