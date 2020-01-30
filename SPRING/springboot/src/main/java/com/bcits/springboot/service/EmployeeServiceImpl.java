package com.bcits.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.springboot.beans.EmployeeInfoBean;
import com.bcits.springboot.customeexception.EmployeeException;
import com.bcits.springboot.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		 

		return dao.authenticate(empId, password);
		
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		
		return dao.addEmployee(employeeInfoBean);
	}

	@Override
	public boolean deleteEmployee(int empId) {
		 if(empId < 1) {
			 return false;
		 }
		return dao.deleteEmployee(empId);
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		
		return dao.updateEmployee(employeeInfoBean);
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		if(empId < 1) {
		    throw new EmployeeException("Invalid Employee Id");
//			return null;
		 }
		
		EmployeeInfoBean employeeInfoBean=  dao.getEmployee(empId);
		
		if (employeeInfoBean == null) {
//			throw new EmployeeException("Employee Id not Found");
			return null;
		}
		return employeeInfoBean;
	}//End of get Employee

	@Override
	public List<EmployeeInfoBean> getAllEmployee() {
		
		return dao.getAllEmployee();
	}

}
