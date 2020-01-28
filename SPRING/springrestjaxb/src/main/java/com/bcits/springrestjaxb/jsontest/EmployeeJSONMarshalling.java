package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeJSONMarshalling {
	
	public static void main(String[] args) {
		
		EmployeeInfoBean employeeInfoBean=new EmployeeInfoBean();
		employeeInfoBean.setEmpId(101);
		employeeInfoBean.setName("Charan");
		employeeInfoBean.setOfficialMailid("charan@gmail.com");
		employeeInfoBean.setDateOfBirth(new Date());
		employeeInfoBean.setDateOfJoining(new Date());
		employeeInfoBean.setDesignation("Developer");
		employeeInfoBean.setMobileNo(9908068809L);
		employeeInfoBean.setSalary(70000.0);
		employeeInfoBean.setDeptId(30);
		employeeInfoBean.setManagerId(333);
		employeeInfoBean.setBloodGroup("b+");
		employeeInfoBean.setPassword("qwerty");
		
		//Marshalling  into Json
		
		
		try {
			ObjectMapper mapper=new ObjectMapper();
			mapper.writerWithDefaultPrettyPrinter();  //formated Json object
			mapper.writeValue(new File("empJson5.json"), employeeInfoBean);
			mapper.writeValue(System.out, employeeInfoBean);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}//End of main

}//End of class
