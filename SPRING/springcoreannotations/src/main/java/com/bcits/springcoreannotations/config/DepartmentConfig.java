package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;

import com.bcits.springcoreannotations.beans.DeparmentBean;

public class DepartmentConfig {
	
//	@Bean
//	public DeparmentBean getDeparmentBean() {
//		DeparmentBean deparmentBean=new DeparmentBean();
//		deparmentBean.setDeptId(10);
//		deparmentBean.setDeptName("Developer");
//		
//		return deparmentBean;
//	}//End of deptBean
	
	
	//For multiple departments
	@Bean(name="dev")
	public DeparmentBean getDeptDev() {
		DeparmentBean deparmentBean=new DeparmentBean();
		deparmentBean.setDeptId(10);
		deparmentBean.setDeptName("Developer");
		
		return deparmentBean;
	}//End of deptBean
	
	@Bean(name="hr")
//	@Primary
	public DeparmentBean getDeptHR() {
		DeparmentBean deparmentBean=new DeparmentBean();
		deparmentBean.setDeptId(11);
		deparmentBean.setDeptName("HR");
		
		return deparmentBean;
	}//End of deptBean
	
	@Bean(name="acc")
	public DeparmentBean getDeptAccount() {
		DeparmentBean deparmentBean=new DeparmentBean();
		deparmentBean.setDeptId(11);
		deparmentBean.setDeptName("Account");
		
		return deparmentBean;
	}//End of deptBean


}
