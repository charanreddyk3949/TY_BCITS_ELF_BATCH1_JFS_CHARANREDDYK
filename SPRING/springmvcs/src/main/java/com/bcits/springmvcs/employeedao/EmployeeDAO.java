package com.bcits.springmvcs.employeedao;

import java.util.List;

import com.bcits.springmvcs.bean.EmployeeInfoBean;

public interface EmployeeDAO {
	
	public EmployeeInfoBean authenticate(int empId, String password);
	
	public boolean addEmployee(EmployeeInfoBean bean);
	public boolean deleteEmployee(Integer empId);
	public boolean updateEmployee(EmployeeInfoBean bean);
	public EmployeeInfoBean getEmployee(Integer empId);
	public List<EmployeeInfoBean> getAllEmployee();

}
