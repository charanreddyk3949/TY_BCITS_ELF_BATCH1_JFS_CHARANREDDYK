package com.bcits.springcore.beans;

import com.bcits.springcore.DepartmentBean;

import lombok.Data;
@Data
public class EmployeeBean {

	private String name;
	private int Age;
	
	private DepartmentBean deparmentBean;

	
}
