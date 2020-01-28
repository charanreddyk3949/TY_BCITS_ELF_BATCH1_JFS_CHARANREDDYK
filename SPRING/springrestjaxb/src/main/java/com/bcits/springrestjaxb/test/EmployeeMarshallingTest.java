package com.bcits.springrestjaxb.test;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;

public class EmployeeMarshallingTest {
   
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
		
		try {
			JAXBContext context=JAXBContext.newInstance(EmployeeInfoBean.class);  //It binds the Employee Object
			Marshaller  marshaller=context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //Set the elements in formate
			marshaller.marshal(employeeInfoBean, System.out);    //Display in console
			marshaller.marshal(employeeInfoBean, new File("employeeInfo.xml"));//Store in xml file
			
		} catch (JAXBException e) {
			e.printStackTrace();
			System.out.println(" \n Unable to Marshal");
		}
		
		
	}//End of main

}//End of class
