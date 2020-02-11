package com.bcits.springsecurityrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.springsecurityrest.beans.EmpInfoBean;
import com.bcits.springsecurityrest.beans.EmployeeResponse;
import com.bcits.springsecurityrest.service.EmpService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmpService service;

	@GetMapping("/getEmployee")
	public EmployeeResponse getEmployee(int empId) {
		
		EmpInfoBean empInfo=service.getEmplioyee(empId);
		EmployeeResponse response=new EmployeeResponse();
		
		if (empInfo != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employee Record Found");
			response.setEmpInfo(empInfo);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Employee Record Not Found");
		}
		return response;
		
	}//End of getEmployee()
	
	@GetMapping("/getAllEmployees")
	public  EmployeeResponse getAllEMployees() {
		List<EmpInfoBean> employeesList=service.getAllEmployees();
		
        EmployeeResponse response=new EmployeeResponse();
		
		if (employeesList != null && !employeesList.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Employees Data Found.");
			response.setEmployeesList(employeesList);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("No Records to display!");
		}
		return response;
		
	}//End of getAllEmployees()
	
	
}//ENd of class
