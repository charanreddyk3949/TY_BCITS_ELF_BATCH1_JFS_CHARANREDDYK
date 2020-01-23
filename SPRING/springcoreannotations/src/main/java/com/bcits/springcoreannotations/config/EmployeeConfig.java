package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bcits.springcoreannotations.beans.EmployeeBean;

@Configuration
public class EmployeeConfig {
	
//	@Bean
//	public EmployeeBean getEmployeeBean() {
//		//Static values
//		EmployeeBean employeeBean=new EmployeeBean();
//		employeeBean.setName("charan");
//		employeeBean.setAge(23);
//		return employeeBean;
//		//Dynamic values
//		return new EmployeeBean();
//		
//	}//End of getEmployeeBean
//	
	@Bean
	/* @Scope("prototype") *///instance is created by container by required number of times
	public EmployeeBean getEmployeeBean() {
		
		return new EmployeeBean();
		
	}//End of getEmployeeBean


}//End of class
