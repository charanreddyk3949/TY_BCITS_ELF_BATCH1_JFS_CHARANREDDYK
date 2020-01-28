package com.bcits.springmvcs.bean;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="employee_primary_info")
public class EmployeeInfoBean implements Serializable{
	  

	  
	    @Id
		@Column(name="emp_id")
		private Integer empId;
		@Column
		private String name;
		@Column(name="mobile_no")
		private Long mobileNo;
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
		private Double salary;
		@Column(name="dept_id")
		private Integer deptId;
		@Column(name="manager_id")
		private Integer managerId;
		@Column
		private String password;
        
		
}
