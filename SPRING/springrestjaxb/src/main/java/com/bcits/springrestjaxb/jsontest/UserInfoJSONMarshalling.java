package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.UserAddressBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;
import com.bcits.springrestjaxb.beans.UserOtherInfoBean;

public class UserInfoJSONMarshalling {
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
			ObjectMapper mapper=new ObjectMapper();
			mapper.writerWithDefaultPrettyPrinter();  //formated Json object
			mapper.writeValue(new File("userInfoJson2.json"), userInfo);
			mapper.writeValue(System.out, userInfo);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}//End of main

}//End of class

  
