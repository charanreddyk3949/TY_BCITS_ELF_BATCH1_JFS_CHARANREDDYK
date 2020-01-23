package com.bcits.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.EmployeeBean;

public class EmployeeTest2 {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("importAllConfig.xml");
//		EmployeeBean employeeBean=context.getBean("employee",EmployeeBean.class);
		EmployeeBean employeeBean=(EmployeeBean) context.getBean("employee");
		
		System.out.println("Name= "+employeeBean.getName());
		System.out.println("Age= "+employeeBean.getAge());
		System.out.println("Department Id= "+employeeBean.getDeparmentBean().getDeptId());
		System.out.println("Department Name= "+employeeBean.getDeparmentBean().getDeptName());
		
	}// End of main

}//End of class
