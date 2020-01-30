package com.bcits.springboot.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bcits.springboot.beans.EmployeeResponse;
import com.bcits.springboot.customeexception.EmployeeException;

@RestControllerAdvice
public class EmployeeRestControllerAdvice {
	
	@ExceptionHandler(EmployeeException.class)
	public EmployeeResponse handleEmployeeException(EmployeeException ex) {
		
		EmployeeResponse response=new EmployeeResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(ex.getMessage());
		
		return response;
		
	}//End of handleEmployeeException()

}//End of class
