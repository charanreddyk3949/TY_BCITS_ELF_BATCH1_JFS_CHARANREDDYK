package com.bcits.springsecurityrest.dao;

import java.util.List;

import com.bcits.springsecurityrest.beans.EmpInfoBean;


public interface EmpDAO {
	
	
   public boolean register(EmpInfoBean empInfoBean);	
   public EmpInfoBean getEmplioyee(int empId);
   public List<EmpInfoBean> getAllEmployees();
}
