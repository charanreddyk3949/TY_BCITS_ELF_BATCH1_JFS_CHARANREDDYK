package com.bcits.discomusecase.service;

import com.bcits.discomusecase.beans.EmployeeMaster;

public interface EmployeeService {
	
	
	public EmployeeMaster authenticate(Integer empId,String password);

}
