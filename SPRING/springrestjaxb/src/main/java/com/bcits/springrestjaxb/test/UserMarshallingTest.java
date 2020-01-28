package com.bcits.springrestjaxb.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;
import com.bcits.springrestjaxb.beans.UserAddressBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;
import com.bcits.springrestjaxb.beans.UserOtherInfoBean;

public class UserMarshallingTest {
	public static void main(String[] args) {
		
	
	UserInfoBean userInfo=new UserInfoBean();
	userInfo.setUserId(111);
	userInfo.setName("Charan");
	userInfo.setOfficialMailid("charan@gmail.com");
	userInfo.setDateOfBirth(new Date());
	userInfo.setDateOfJoining(new Date());
	userInfo.setDesignation("Developer");
	userInfo.setMobileNo(9908068809L);
	userInfo.setSalary(70000.0);
	userInfo.setDeptId(30);
	userInfo.setManagerId(333);
	userInfo.setBloodGroup("b+");
	userInfo.setPassword("qwerty");
	
	UserOtherInfoBean userOtherInfo=new UserOtherInfoBean();
	userOtherInfo.setGender("male");
	userOtherInfo.setAadharNumber(24872592510L);
	
	userInfo.setOtherInfoBean(userOtherInfo);
	
	UserAddressBean  tempAddress= new UserAddressBean();
	tempAddress.setHouseNum(1);
	tempAddress.setStreet("abc street");
	tempAddress.setCity("BLR");
	tempAddress.setAddressType('t');
	
	UserAddressBean permanentAddress= new UserAddressBean();
	permanentAddress.setHouseNum(2);
	permanentAddress.setStreet("xyz street");
	permanentAddress.setCity("Hyd");
	permanentAddress.setAddressType('c');
	
	List<UserAddressBean> userAddressesList=new ArrayList<>();
	userAddressesList.add(tempAddress);
	userAddressesList.add(permanentAddress);
	userInfo.setUserAddressesList(userAddressesList);
	
	try {
		JAXBContext context=JAXBContext.newInstance(UserInfoBean.class);  //It binds the Employee Object
		Marshaller  marshaller=context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //Set the elements in formate
		marshaller.marshal(userInfo, System.out);    //Display in console
		marshaller.marshal(userInfo, new File("userInfo2.xml"));//Store in xml file
		
	} catch (JAXBException e) {
		e.printStackTrace();
		System.out.println(" \n Unable to Marshal");
	}
	
	
}//End of main

}//End of class

