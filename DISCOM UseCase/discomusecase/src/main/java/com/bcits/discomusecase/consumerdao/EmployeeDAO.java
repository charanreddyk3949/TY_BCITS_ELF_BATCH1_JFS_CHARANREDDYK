package com.bcits.discomusecase.consumerdao;

import org.springframework.beans.factory.annotation.Autowired;

import com.bcits.discomusecase.beans.EmployeeMaster;

public interface EmployeeDAO {
	
	
	public EmployeeMaster authenticate(Integer empId,String password);
	

}
