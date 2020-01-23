package com.bcits.springcore.beans;

import com.bcits.springcore.DepartmentBean;

import lombok.Data;
@Data
public class EmployeeBean {

	private String name;
    private int Age;
	
	private DepartmentBean deparmentBean;
	
	EmployeeBean(){
		
	}

	public EmployeeBean(String name, int age, DepartmentBean deparmentBean) {
		super();
		this.name = name;
		Age = age;
		this.deparmentBean = deparmentBean;
	}

	

	
}//End of class
