package com.bcits.springrestjaxb.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.bcits.springrestjaxb.beans.UserAddressBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;

public class UserUnmarshalling {
	
    public static void main(String[] args) {
		
		JAXBContext jaxbContext;
		try {
			jaxbContext =JAXBContext.newInstance(UserInfoBean.class);
			Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
			
			UserInfoBean userInfoBean=(UserInfoBean) unmarshaller.unmarshal(new File("userInfo2.xml"));
			
			System.out.println("User Id ="+userInfoBean.getUserId());
			System.out.println("Name ="+userInfoBean.getName());
			System.out.println("Salary ="+userInfoBean.getSalary());
			System.out.println("DOB ="+userInfoBean.getDateOfBirth());
			System.out.println("DOJ ="+userInfoBean.getDateOfJoining());
			System.out.println("Email ="+userInfoBean.getOfficialMailid());
			
			System.out.println("Gender ="+userInfoBean.getOtherInfoBean().getGender());
			System.out.println("Aadhar ="+userInfoBean.getOtherInfoBean().getAadharNumber());
			
			
			for (UserAddressBean  userInfo : userInfoBean.getUserAddressesList()) {
				System.out.println("House No ="+userInfo.getHouseNum());
				System.out.println("Street ="+userInfo.getStreet());
				System.out.println("City ="+userInfo.getCity());
			}
		} catch (JAXBException e) {
			
			e.printStackTrace();
		}
		
		
	}//End of main

}//End of class