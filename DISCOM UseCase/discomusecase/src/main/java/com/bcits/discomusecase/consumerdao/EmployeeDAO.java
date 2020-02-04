package com.bcits.discomusecase.consumerdao;

import java.util.List;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.EmployeeMaster;

public interface EmployeeDAO {
	
	
	public EmployeeMaster authenticate(Integer empId,String password);
	
	public EmployeeMaster getEmployeedetails(int empId);
	
	public List<ConsumersMasterBean> getemployeeConsumers(String region);
		
	
	

}
