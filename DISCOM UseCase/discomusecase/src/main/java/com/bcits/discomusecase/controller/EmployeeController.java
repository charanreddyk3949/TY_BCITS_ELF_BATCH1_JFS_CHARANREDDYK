package com.bcits.discomusecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.service.ConsumerService;
import com.bcits.discomusecase.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	 private EmployeeService service;
	
	@Autowired
	private ConsumerService servicec;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);	
	}//End of initBinder()
	
	@GetMapping("/employeeLogin")
	public String displayEmployeeLoginForm() {
		
		return "employeeLogin";
		
	}//End of displayEmployeeLoginForm()
	
	@PostMapping("/empLogin")
	public String authenticate(Integer empId, String password,HttpServletRequest req, ModelMap modelMap) {

		EmployeeMaster employeeMaster=service.authenticate(empId, password);
		
		if (employeeMaster != null) {
			//Valid credentials
			HttpSession session= req.getSession(true);
			modelMap.addAttribute("loggedinEmpInfo", employeeMaster);
			
			EmployeeMaster master=service.getEmployeedetails(empId);
			if (master != null) {
				modelMap.addAttribute("EmployeeDetails", master);
			}else {
				session.setAttribute("msg", "No Employee Details Found");
			}	
			return "employeeHome";	
		}else {
			//Invalid credentials
			modelMap.addAttribute("errMsg", "Invalid Credentials");
			return "employeeLogin";
		}
	}//End of authenticate()
	
	
	//@RequestMapping(path = "/getConsumers" ,method = RequestMethod.GET)
	@GetMapping("/employeeConsumerDetails")
	public String getEmployeeHome(String region,@SessionAttribute(name = "loggedinEmpInfo" ,required = false) EmployeeMaster employeemaster,ModelMap modelMap) {
		
		if (employeemaster != null) {
			//Valid Session
			
	       List<ConsumersMasterBean> masterBean= service.getemployeeConsumers(region);
			if (masterBean != null ) {
				
			modelMap.addAttribute("consumerDetails",masterBean);
			
			}else {
				modelMap.addAttribute("errMsg", "No consumers in this region");
			}
			return "employeeHome";
		}else {
			//Invalid Session
			modelMap.addAttribute("errMsg", "Please Login first");
			
			return "empLogin";
		}
		
	}
	
}//End of controller
