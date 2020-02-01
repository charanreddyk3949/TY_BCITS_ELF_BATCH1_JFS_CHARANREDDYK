package com.bcits.discomusecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcits.discomusecase.service.ConsumerService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	 private ConsumerService service;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);	
	}//End of initBinder()
	
	@GetMapping("/employeeLogin")
	public String displayEmployeeLoginForm() {
		
		return "employeeLogin";
		
	}//End of displayEmployeeLoginForm()
	
	
	
	
}//End of controller
