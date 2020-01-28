package com.bcits.springrestjaxb.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import lombok.Data;
@JsonRootName("addressInfo") 
@Data
@XmlRootElement(name = "user-address")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAddressBean {
	@JsonProperty("housse-no")
	@XmlElement(name = "house-number")
	private int houseNum;
	@XmlElement
	private String street;
	@XmlElement
	private String city;
	@XmlElement(name = "address-type")
	private char addressType;

}
