package com.bcits.discomusecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.consumerdao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public EmployeeMaster authenticate(Integer empId, String password) {
		
		return dao.authenticate(empId, password);
	}

}
