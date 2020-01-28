package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;

public class UserInfoJSONUnmarshalling {
public static void main(String[] args) {
		
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			
			ObjectMapper mapper=new ObjectMapper();
			UserInfoBean usInfoBean=objectMapper.readValue(new File("userInfoJson1.json"), UserInfoBean.class);
			
			System.out.println("Emp Id ="+usInfoBean.getUserId());
			System.out.println("Name ="+usInfoBean.getName());
			System.out.println("Salary ="+usInfoBean.getSalary());
			System.out.println("DOB ="+usInfoBean.getDateOfBirth());
			System.out.println("DOJ ="+usInfoBean.getDateOfJoining());
			System.out.println("Password ="+usInfoBean.getPassword());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
