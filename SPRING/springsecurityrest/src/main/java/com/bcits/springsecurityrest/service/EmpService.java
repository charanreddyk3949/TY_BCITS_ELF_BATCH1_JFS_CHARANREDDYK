package com.bcits.springsecurityrest.service;

import java.util.List;

import com.bcits.springsecurityrest.beans.EmpInfoBean;

public interface EmpService {

	
	public boolean register(EmpInfoBean empInfoBean);	
	public EmpInfoBean getEmplioyee(int empId);
	public List<EmpInfoBean> getAllEmployees();
}
