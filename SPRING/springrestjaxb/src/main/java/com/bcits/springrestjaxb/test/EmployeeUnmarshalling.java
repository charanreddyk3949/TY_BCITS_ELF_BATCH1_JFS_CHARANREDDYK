package com.bcits.springrestjaxb.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeUnmarshalling {
	
	public static void main(String[] args) {
		
		JAXBContext jaxbContext;
		try {
			jaxbContext =JAXBContext.newInstance(EmployeeInfoBean.class);
			Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
			
			EmployeeInfoBean employeeInfoBean=(EmployeeInfoBean) unmarshaller.unmarshal(new File("employeeInfo2.xml"));
			
			System.out.println("Emp Id ="+employeeInfoBean.getEmpId());
			System.out.println("Name ="+employeeInfoBean.getName());
			System.out.println("Salary ="+employeeInfoBean.getSalary());
			System.out.println("DOB ="+employeeInfoBean.getDateOfBirth());
			System.out.println("DOJ ="+employeeInfoBean.getDateOfJoining());
			System.out.println("Email ="+employeeInfoBean.getOfficialMailid());
			
		} catch (JAXBException e) {
			
			e.printStackTrace();
		}
		
		
	}//End of main

}//End of class
