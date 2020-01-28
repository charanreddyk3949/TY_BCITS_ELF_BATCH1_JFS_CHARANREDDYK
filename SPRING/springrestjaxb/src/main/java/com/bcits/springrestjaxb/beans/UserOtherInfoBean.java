package com.bcits.springrestjaxb.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import lombok.Data;
@JsonRootName("user-other-info")
@Data
@XmlRootElement(name = "user-other-info")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserOtherInfoBean {
	@JsonProperty
	@XmlElement
	private String gender;
	@XmlElement(name = "aadhar")
	private long aadharNumber;

}//End of class
