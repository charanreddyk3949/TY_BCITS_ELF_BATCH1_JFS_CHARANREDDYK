package com.bcits.discomusecase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
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

	@Override
	public List<ConsumersMasterBean> getemployeeConsumers(String region) {
		
		return  dao.getemployeeConsumers(region);
		
	}

	@Override
	public EmployeeMaster getEmployeedetails(int empId) {
		
		return dao.getEmployeedetails(empId);
	}

}//End of Service
