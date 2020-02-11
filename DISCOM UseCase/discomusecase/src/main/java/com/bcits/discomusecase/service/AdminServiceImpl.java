package com.bcits.discomusecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.AdminBean;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.consumerdao.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO dao;

	@Override
	public AdminBean authenticate(int adminId, String Password) {
		
		return dao.authenticate(adminId, Password);
	}//End of authenticate()

	@Override
	public boolean createEmployee(EmployeeMaster employeeMaster) {
		
		return dao.createEmployee(employeeMaster);
	}

}//End of Class
