package com.bcits.springmvcs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bcits.springmvcs.customexceptions.EmployeeException;

@ControllerAdvice
public class EmployeeControllerAdvise {
	
	@ExceptionHandler(EmployeeException.class)
	public String handleEmployeeException(EmployeeException empEx,HttpServletRequest req) {
		 String errMsg=empEx.getMessage();
		 
		 req.setAttribute("errMsg", errMsg);
		 
		 return "errorPage";
	}

}//End of class
