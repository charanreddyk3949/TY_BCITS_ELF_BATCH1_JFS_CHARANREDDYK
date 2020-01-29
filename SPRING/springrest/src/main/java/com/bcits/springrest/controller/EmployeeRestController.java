package com.bcits.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.springrest.beans.EmployeeInfoBean;
import com.bcits.springrest.beans.EmployeeResponse;
import com.bcits.springrest.service.EmployeeService;

// @Controller
@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping(path= "/getEmployee",
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public EmployeeResponse getEmployee(int empId) {
		EmployeeInfoBean employeeInfoBean=service.getEmployee(empId);
		
		EmployeeResponse response=new EmployeeResponse();
		
		if (employeeInfoBean != null) {
			response.setStatusCode(201);
		    response.setMessage("success");
		    response.setDescription("Employee Record is Found successfully!!!");
		    response.setEmployeeInfoBean(employeeInfoBean);
		    
		}else {
			response.setStatusCode(401);
		    response.setMessage("Failed");
		    response.setDescription("Employee Id is not found");
			
		}
		
		return response;
		
	}//End of getEmployee
	
	@GetMapping(path = "/getAllEmployees",
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
//	@ResponseBody        //we used RestController it will take care of response body
	
	public EmployeeResponse getAllEmployees(){
		
		List<EmployeeInfoBean> employeesList= service.getAllEmployee();
		
      EmployeeResponse response=new EmployeeResponse();
		
		if (employeesList != null) {
			response.setStatusCode(201);
		    response.setMessage("success");
		    response.setDescription("Employee Records Fetched successfully!!!");
		    response.setEmployeesList(employeesList);
		    
		}else {
			response.setStatusCode(401);
		    response.setMessage("Failed");
		    response.setDescription("Unable to Fetch the Records");
			
		}
		
		return response;
		
	}//End of getAllEmployees()
	
//	@DeleteMapping(path = "/deleteEmployee",
//			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
//  public boolean deleteEmployee( int empId) {
//		
//	  return service.deleteEmployee(empId);
//	  
//	}//End of deleteEmployee()
//	
	
	@DeleteMapping(path = "/deleteEmployee/{employeeID}",  //passing the value as an argument
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
  public EmployeeResponse deleteEmployee(@PathVariable(name="employeeID") int empId) {
		
	  boolean isDeleted= service.deleteEmployee(empId);
	  
	  EmployeeResponse response=new EmployeeResponse();
	  
	  if(isDeleted) {
		  response.setStatusCode(201);
		  response.setMessage("success");
		  response.setDescription("Employee Record is Deleted successfully.");
		  
	  }else {
		  response.setStatusCode(401);
		  response.setMessage("Failed");
		  response.setDescription("Unable to Delete the Employee Record!");	
	}
	  return response;
	  
	}//End of deleteEmployee()
	
	
	@PostMapping(path = ("/addEmployee"),
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
public EmployeeResponse  addEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
	
	boolean isAdded= service.addEmployee(employeeInfoBean);
	
	 EmployeeResponse response=new EmployeeResponse();
	  
	  if(isAdded) {
		  response.setStatusCode(201);
		  response.setMessage("success");
		  response.setDescription("Employee Record is Added successfully.");
		  
	  }else {
		  response.setStatusCode(401);
		  response.setMessage("Failed");
		  response.setDescription("Unable to Add the Employee Record!");	
	}
	  return response;
	
}//End of addEmployee()
	
	
	@PutMapping(path = ("/updateEmployee"),
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse updateEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {
		
		boolean isUpdated= service.updateEmployee(employeeInfoBean);
		
		EmployeeResponse response=new EmployeeResponse();
		  
		  if(isUpdated) {
			  response.setStatusCode(201);
			  response.setMessage("success");
			  response.setDescription("Employee Record is Updated successfully.");
			  
		  }else {
			  response.setStatusCode(401);
			  response.setMessage("Failed");
			  response.setDescription("Unable to Update the Employee Record!");	
		}
		  return response;
		  
	}//End of updateEmployee
	
	

}//End of class
