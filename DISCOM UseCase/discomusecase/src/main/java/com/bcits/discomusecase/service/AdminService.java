package com.bcits.discomusecase.service;

import com.bcits.discomusecase.beans.AdminBean;
import com.bcits.discomusecase.beans.EmployeeMaster;

public interface AdminService {

	public AdminBean authenticate(int adminId,String Password);

	public boolean createEmployee(EmployeeMaster employeeMaster);

	
}//End of Interface
