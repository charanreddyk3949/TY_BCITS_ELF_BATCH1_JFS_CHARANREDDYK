package com.bcits.discomusecase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcits.discomusecase.service.EmployeeService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping("/homePage")
	public String getHomePage() {
		return "homePage";
	}

}
