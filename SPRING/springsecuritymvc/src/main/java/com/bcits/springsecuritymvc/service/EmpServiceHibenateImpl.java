package com.bcits.springsecuritymvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bcits.springsecuritymvc.beans.EmpInfoBean;
import com.bcits.springsecuritymvc.dao.EmpDAO;

@Service
public class EmpServiceHibenateImpl implements EmpService {
	
	@Autowired
	private EmpDAO  dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public boolean register(EmpInfoBean empInfoBean) {
		
		if (empInfoBean != null) {
			empInfoBean.setPassword(passwordEncoder.encode(empInfoBean.getPassword()));
			
			return dao.register(empInfoBean);
			
			
		}
		return false;
		
	}//End of register()

	@Override
	public EmpInfoBean getEmplioyee(int empId) {
		
		return dao.getEmplioyee(empId);
	}

	@Override
	public List<EmpInfoBean> getAllEmployees() {
		
		return dao.getAllEmployees();
	}

}//End of Service
