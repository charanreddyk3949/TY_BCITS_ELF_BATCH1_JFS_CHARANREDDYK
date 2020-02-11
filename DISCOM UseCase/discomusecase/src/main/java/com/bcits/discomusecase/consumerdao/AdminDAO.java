package com.bcits.discomusecase.consumerdao;

import com.bcits.discomusecase.beans.AdminBean;
import com.bcits.discomusecase.beans.EmployeeMaster;

public interface AdminDAO {

	public AdminBean authenticate(int adminId,String Password);
	
	public boolean createEmployee(EmployeeMaster employeeMaster);
	
}//End of AdminDAO
