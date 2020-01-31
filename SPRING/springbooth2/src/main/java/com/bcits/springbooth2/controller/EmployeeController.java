package com.bcits.springbooth2.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.springbooth2.beans.EmployeeInfoBean;
import com.bcits.springbooth2.beans.EmployeeResponse;
import com.bcits.springbooth2.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
	@GetMapping(path = "/getEmployee",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeInfoBean getEmployee(int empId) {
		Optional<EmployeeInfoBean> employee=repository.findById(empId);
		
		if (employee.isPresent()) {
			return employee.get();
		}else {
			return null;
		}
	}//End of getEmployee
	
	@PostMapping(path = "/addEmployee",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeInfoBean addEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		EmployeeInfoBean  infoBean=repository.save(employeeInfoBean);
		
		return infoBean;
	}//End of addEmployee
	
	
	@PutMapping(path = "/updateEmployee",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeInfoBean updateEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		EmployeeInfoBean infoBean=repository.save(employeeInfoBean);
		
		return infoBean;
	}//End of upadetEmployee
	
	
	@DeleteMapping(path="/deleteEmployee",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteEmployee(int empId) {
		boolean isDeleted=false;
		if(empId != 0) {
		repository.deleteById(empId);
		
		isDeleted=true;
		return isDeleted;
		}else {
			return isDeleted;
		}
		
	}//End of deleteEmployee
	
	
	@DeleteMapping(path="/deleteEmp",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse deleteEmp(int empId) {
		EmployeeResponse response =new EmployeeResponse();
		try {
			repository.deleteById(empId);
			response.setStatusCode(201);
			response.setMessage("Success ");
			response.setDescription("Employee is deleted Successfully!!!");
			
		} catch (Exception e) {
			response.setStatusCode(401);
			response.setMessage("Failed ");
			response.setDescription("Unable to delete the Employee");
		}
		return response;
	}

}//End of controller
