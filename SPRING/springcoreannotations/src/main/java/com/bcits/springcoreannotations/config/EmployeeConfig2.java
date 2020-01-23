package com.bcits.springcoreannotations.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import com.bcits.springcoreannotations.beans.DeparmentBean;
import com.bcits.springcoreannotations.beans.EmployeeBean;

@Import(DepartmentConfig.class)
@Configuration
public class EmployeeConfig2 {
	
	@Bean
	public EmployeeBean getEmployeeBean() {
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setName("charan");
		employeeBean.setAge(22);
	
//      Manually injecting the bean				
//		employeeBean.setDepartmentBean(getDeparmentBean());  
		
		return employeeBean;
		
	}//End of getEmployeeBean
	
//	@Bean
//	public DeparmentBean getDeparmentBean() {
//		DeparmentBean deparmentBean=new DeparmentBean();
//		deparmentBean.setDeptId(10);
//		deparmentBean.setDeptName("Developer");
//		
//		return deparmentBean;
//	}//End of deptBean
	
	
	//For multiple departments
//	@Bean(name="dev")
//	public DeparmentBean getDeptDev() {
//		DeparmentBean deparmentBean=new DeparmentBean();
//		deparmentBean.setDeptId(10);
//		deparmentBean.setDeptName("Developer");
//		
//		return deparmentBean;
//	}//End of deptBean
//	
//	@Bean(name="hr")
////	@Primary
//	public DeparmentBean getDeptHR() {
//		DeparmentBean deparmentBean=new DeparmentBean();
//		deparmentBean.setDeptId(11);
//		deparmentBean.setDeptName("HR");
//		
//		return deparmentBean;
//	}//End of deptBean
//	
//	@Bean(name="acc")
//	public DeparmentBean getDeptAccount() {
//		DeparmentBean deparmentBean=new DeparmentBean();
//		deparmentBean.setDeptId(11);
//		deparmentBean.setDeptName("Account");
//		
//		return deparmentBean;
//	}//End of deptBean

}//End of class
