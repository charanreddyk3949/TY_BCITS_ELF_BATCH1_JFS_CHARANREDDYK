package com.bcits.springbooth2.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;



@JsonRootName("employeeInfo")
@JsonPropertyOrder({"employeeID","name"})
@JsonInclude(JsonInclude.Include.NON_NULL)  //For ignoring the NULL values

@Data
@Entity
@Table(name="employee_primary_info")
public class EmployeeInfoBean implements Serializable{

	@JsonProperty("employeeId")
    @Id
	@Column(name="emp_id")
//    @XmlElement(name="emp-id")
    
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
	
// @JsonIgnore
	@Column
	private String password;
	
}//End of bean
