package com.bcits.discomusecase.service;

import java.util.Date;
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
	public EmployeeMaster getEmployeedetails(Integer empId) {
		
		return dao.getEmployeedetails(empId);
	}

	@Override
	public ConsumersMasterBean getConsumer(String rrNumber) {
		
		return dao.getConsumer(rrNumber);
	}

	@Override
	public Double getFinalReading(String rrNumber) {
		
		return dao.getFinalReading(rrNumber);
	}

	

}//End of Service
