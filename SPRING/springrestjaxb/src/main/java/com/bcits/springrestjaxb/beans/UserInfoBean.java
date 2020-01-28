package com.bcits.springrestjaxb.beans;

import java.util.Date;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import lombok.Data;


@JsonRootName("userInfo")

@Data
@XmlRootElement(name="User-info")
@XmlAccessorType(XmlAccessType.FIELD) //To specify fields(at getter method)
public class UserInfoBean {
  
	@JsonProperty("userId")
	
//	@XmlElement(name="employee-id") //set as a Element
	@XmlAttribute(name="user-id")  //Set as a attribute to root element 
	private Integer userId;
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
    @XmlElement	
//	@XmlTransient             //remove this element from xml file
	private String password;
    
    @XmlElement(name = "user-other-info")
    private UserOtherInfoBean otherInfoBean;
    
    @XmlElementWrapper(name = "user-addresses-list")
    private List<UserAddressBean> userAddressesList;

}//End of class
