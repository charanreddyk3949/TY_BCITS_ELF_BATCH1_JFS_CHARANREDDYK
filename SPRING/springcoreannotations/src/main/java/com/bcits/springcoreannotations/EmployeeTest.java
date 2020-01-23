package com.bcits.springcoreannotations;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreannotations.beans.EmployeeBean;
import com.bcits.springcoreannotations.config.EmployeeConfig;

public class EmployeeTest {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfig.class);
		((ConfigurableApplicationContext)context).registerShutdownHook();;
		EmployeeBean employeeBean=context.getBean(EmployeeBean.class);
		
		//Dynamic input values
		System.out.println("Enter Employee-1 Name...");
		employeeBean.setName(sc.nextLine());
		System.out.println("Enter Employee-1 Age...");
		employeeBean.setAge(sc.nextInt()); 
		sc.nextLine();
		
		EmployeeBean employeeBean2=context.getBean(EmployeeBean.class);
		System.out.println("Enter Employee-2 Name...");
		employeeBean2.setName(sc.nextLine());
		System.out.println("Enter Employee-2 Age...");
		employeeBean2.setAge(sc.nextInt());
	
		System.out.println("Employee-1 Name= "+employeeBean.getName());
		System.out.println("Employee-1 Age=  "+employeeBean.getAge());
		System.out.println("Employee-2 Name= "+employeeBean2.getName());
		System.out.println("Employee-2 Age=  "+employeeBean2.getAge());
		
		
	}//End of main

}//End of class
