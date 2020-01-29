package com.bcits.springrest.dao;

import java.util.List;

import org.springframework.context.annotation.Bean;

import com.bcits.springrest.beans.EmployeeInfoBean;

public interface EmployeeDAO {
	
	
	public EmployeeInfoBean authenticate(int empId, String password);
	
	public boolean addEmployee(EmployeeInfoBean bean);
	public boolean deleteEmployee(Integer empId);
	public boolean updateEmployee(EmployeeInfoBean bean);
	public EmployeeInfoBean getEmployee(Integer empId);
	public List<EmployeeInfoBean> getAllEmployee();

}
