package com.bcits.springsecuritymvc.service;

import java.util.List;

import com.bcits.springsecuritymvc.beans.EmpInfoBean;

public interface EmpService {

	
	public boolean register(EmpInfoBean empInfoBean);	
	public EmpInfoBean getEmplioyee(int empId);
	public List<EmpInfoBean> getAllEmployees();
}
