package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeJSONUnmarshalling {
	public static void main(String[] args) {
		
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			
			ObjectMapper mapper=new ObjectMapper();
			EmployeeInfoBean employeeInfoBean=objectMapper.readValue(new File("empjson4.json"), EmployeeInfoBean.class);
			
			System.out.println("Emp Id ="+employeeInfoBean.getEmpId());
			System.out.println("Name ="+employeeInfoBean.getName());
			System.out.println("Salary ="+employeeInfoBean.getSalary());
			System.out.println("DOB ="+employeeInfoBean.getDateOfBirth());
			System.out.println("DOJ ="+employeeInfoBean.getDateOfJoining());
			System.out.println("Password ="+employeeInfoBean.getPassword());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
