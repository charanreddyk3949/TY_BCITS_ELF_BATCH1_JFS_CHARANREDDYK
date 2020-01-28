package com.bcits.springrestjaxb.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonRootName;

import lombok.Data;

@JsonRootName("employeeInfo")   //Json defining root element
@JsonPropertyOrder({"employeeId","name","salary"}) //Json Order of elements

@Data
@XmlRootElement(name="Employee-info")
@XmlAccessorType(XmlAccessType.FIELD) //To specify fields(at getter method)
public class EmployeeInfoBean {
	
	
	
   @JsonProperty("employeeId")      //JSON set name to the element
//	@XmlElement(name="employee-id") //set as a Element
	@XmlAttribute(name="emp-id")  //Set as a attribute to root element 
	private Integer empId;
	@XmlElement
	private String name;
	@XmlElement
	private Long mobileNo;
	@XmlElement
	private String officialMailid;
	@XmlElement
	private Date dateOfBirth;
	@XmlElement
	private Date dateOfJoining;
	@XmlElement
	private String designation;
	@XmlElement
	private String bloodGroup;
	@XmlElement
	private Double salary;
	@XmlElement(name = "department-id")
	private Integer deptId;
       @XmlElement
 //	@XmlTransient 
	private Integer managerId;
       
    @JsonIgnore   //JSON ignore the element and also its possible in empJson4
    @XmlElement	
//	@XmlTransient             //remove this element from xml file
	private String password;

}//End of class
