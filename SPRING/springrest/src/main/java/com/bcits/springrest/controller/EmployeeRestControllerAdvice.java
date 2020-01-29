package com.bcits.springrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bcits.springrest.beans.EmployeeResponse;
import com.bcits.springrest.customeexceptions.EmployeeException;

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
