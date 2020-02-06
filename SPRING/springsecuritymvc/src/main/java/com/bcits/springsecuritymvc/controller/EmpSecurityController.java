package com.bcits.springsecuritymvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bcits.springsecuritymvc.beans.EmpInfoBean;
import com.bcits.springsecuritymvc.service.EmpService;

@Controller
public class EmpSecurityController {
	
	@Autowired
	private EmpService service;

	@GetMapping("/index")
	public String getIndexPage() {
		return "index";
		
	}//End of getIndexPage()
	
	@GetMapping("/register")
	public String getRegisterForm() {
			return "register";
	}
	
	@PostMapping("/register")
	public String register(EmpInfoBean empInfoBean,ModelMap modelMap) {
	    boolean isRegistered=service.register(empInfoBean);
	    
	    if (isRegistered) {
			modelMap.addAttribute("msg", "Registered Successfully...");
		}else {
			modelMap.addAttribute("errMsg", "Registration failed");
		}
		return "register";
	}//End of register()
	
	@GetMapping("/adminSecureHome")
	public String getAdminHomePage() {
		return "adminHomePage";
	}//End of getAdminHomePage()
	
	@GetMapping("/userSecureHome")
	public String getUserHomePage() {
		return "userHomePage";
	}//End of getUserHomePage()
	
	@GetMapping("/getEmployeeForm")
	public String getEmployeePage() {
		return "search";
	}
	
	@GetMapping("/getEmployee")
	public String getEmployee(int empId,ModelMap modelMap) {
		EmpInfoBean infoBean=service.getEmplioyee(empId);
		
		modelMap.addAttribute("empInfo", infoBean);
		
		return "search";
	}
	
	@GetMapping("/getAllEmployees")
	public String getAllEmployees(ModelMap modelMap) {
		modelMap.addAttribute("employeesList", service.getAllEmployees());
		
		return "getAllEmployees";
	}
	
}//End of Controller
