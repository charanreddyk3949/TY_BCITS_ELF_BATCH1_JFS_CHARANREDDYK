package com.bcits.discomusecase.service;

import java.util.Date;
import java.util.List;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.EmployeeMaster;

public interface EmployeeService {
	
	
	public EmployeeMaster authenticate(Integer empId,String password);
	
	public EmployeeMaster getEmployeedetails(Integer empId);

	public List<ConsumersMasterBean> getemployeeConsumers(String region);
	
	public ConsumersMasterBean getConsumer(String rrNumber);
	public Double getFinalReading(String rrNumber);
	

}
