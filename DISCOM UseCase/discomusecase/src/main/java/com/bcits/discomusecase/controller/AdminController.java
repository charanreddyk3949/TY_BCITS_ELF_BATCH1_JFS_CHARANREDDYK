package com.bcits.discomusecase.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.discomusecase.beans.AdminBean;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/adminLoginForm")
	public String getAdminLoginForm() {
		return "adminLogin";
	}//End of getAdminLoginForm()
	
	@GetMapping("/employeeCreateForm")
	public String getAdminCreateForm() {
		return "employeeCreatePage";
	}//End of getAdminLoginForm()
	
	
	@PostMapping("/adminLogin")
	public  String  authenticate(int adminId,String password,HttpServletRequest request,ModelMap modelMap) {
		AdminBean adminBean=service.authenticate(adminId, password);
		
		if (adminBean != null) {
			HttpSession session=request.getSession(true);
			session.setAttribute("LoggedInAdminInfo", adminBean);
			
		  return "adminHome";
		}else {
			modelMap.addAttribute("errMsg", "Please enter Valid Credentials.");
			return "adminLogin";
		}
	}//End of authenticate()
	
	@PostMapping("/createEmployee")
	public String createEmployee(@SessionAttribute(name = "LoggedInAdminInfo",required = false)AdminBean adminBean, EmployeeMaster employeeMaster,ModelMap modelMap) {
		if (adminBean != null) {
		   if (service.createEmployee(employeeMaster)) {
			    modelMap.addAttribute("msg", "Employee is Created Successfully!!!");
				
			 } else {
				modelMap.addAttribute("errMsg", "Unable to create the Employee");
			 }
			   return "adminHome";
			
		}else {
			modelMap.addAttribute("errMsg", "Please Login First!");
			return "adminLogin";
		}
		
	}//End of createEmployee()
	
	@GetMapping("/adminLogout")
	public String getLogout(HttpSession session,ModelMap  modelMap) {
		session.invalidate();
		modelMap.addAttribute("errMsg", "Lougged Out SuccessFully!!");
		
		return "adminLogin";
		
	}//End of getLogout()

}//End of Controller
