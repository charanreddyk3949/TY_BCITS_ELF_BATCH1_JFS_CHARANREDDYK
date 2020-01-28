package com.bcits.springmvcs.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.springmvcs.bean.EmployeeInfoBean;
import com.bcits.springmvcs.crud.EmployeeDAOHibernateImpl;
import com.bcits.springmvcs.employeedao.EmployeeDAO;
import com.bcits.springmvcs.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
		
	}
	
	@Autowired
	 private EmployeeService service;
	
	@GetMapping("/login")
	public String displayForm() {
		return "empLoginForm";
		
	}//End of displayForm()
	
	@PostMapping("/login")
	public String authenticate(int empId, String password,HttpServletRequest req, ModelMap modelMap) {
//		EmployeeDAO dao =new EmployeeDAOHibernateImpl();
		EmployeeInfoBean employeeInfoBean=service.authenticate(empId, password);
		
		if (employeeInfoBean != null) {
			//Valid credentials
			HttpSession session= req.getSession(true);
			session.setAttribute("loggedinEmpInfo", employeeInfoBean);
			
			return "employeeHome";	
		}else {
			//Invalid credentials
			modelMap.addAttribute("errMsg", "Invalid Credentials");
			return "empLoginForm";
		}
	}//End of authenticate()
	
	@GetMapping("/searchEmpForm")
	public String displaySearchEmployeeForm(HttpSession session ,ModelMap modelMap) {
		
		if (session.isNew()) {
			//User not logged In
			session.invalidate();
			
			modelMap.addAttribute("errMsg", "Please Login First!");
			return "empLoginForm";
		}else {
			
			//User already logged In
			return "searchEmp";
		}
		
	}
	
	@GetMapping("/search")
	public String searchEmployee(int empId, HttpSession session,ModelMap modelMap) {
		
		if (session.getAttribute("loggedinEmpInfo") != null) {
			//Valid Session
			
//			EmployeeDAO dao= new EmployeeDAOHibernateImpl();
			EmployeeInfoBean employeeInfoBean= service.getEmployee(empId);
			
			if (employeeInfoBean != null) {
				modelMap.addAttribute("employeeInfoBean", employeeInfoBean);
				
			}else {
				modelMap.addAttribute("errMsg", "Employee Id Not found");
			}
			return "searchEmp";
		}else {
			
			modelMap.addAttribute("errMsg", "Please Login First");
			
			return "empLoginForm";
		}
	}//End of 
	
	@GetMapping("/deleteEmpForm")
	public String displayDeleteEmployeeForm(
			
			@SessionAttribute(name = "loggedinEmpInfo",required = false)EmployeeInfoBean employeeInfoBean, ModelMap modelMap) {
		if(employeeInfoBean != null) {
			// valid session
			return "deleteEmpForm";
		}else {
			//Invalid session
			modelMap.addAttribute("errMsg", "Please Login first");
			return "empLoginForm";
		}
			
	}// End of 
	
	@GetMapping("/delete")
	public String  deleteEmployee(int empId,
			@SessionAttribute(name = "loggedinEmpInfo",required = false)EmployeeInfoBean employeeInfoBean,ModelMap modelMap) {
		
		if(employeeInfoBean != null) {
		   // valid
			if(service.deleteEmployee(empId)) {
				modelMap.addAttribute("msg", "Employee Record is Deleted Successfully!");
			}else {
				modelMap.addAttribute("errMsg", "Employee Id not Found!");
			}
			return "deleteEmpForm";
		}else {
			modelMap.addAttribute("errMsg", "Please Login first");
			return "empLoginForm";
		}
	}// End of Deleteemployee()
	
	@GetMapping("/logout")
	public String logout(HttpSession session,ModelMap modelMap  ) {
		session.invalidate();
		modelMap.addAttribute("errMsg", "you are logged out successfully!!");
		
		return "empLoginForm";
	}//End of logged out
	
	@GetMapping("/addForm")
	public String getAddEmployeeForm(HttpSession session,ModelMap modelMap) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please login First...");
			return "empLoginForm";
		}else {
			return "addEmpForm";
		}
		
	}//End of  getEMplyeeForm()
	
	@PostMapping("/addEmp")
	public String addEmployee(@SessionAttribute(name = "loggedinEmpInfo",required = false)EmployeeInfoBean employeeInfoBean,ModelMap modelMap, EmployeeInfoBean employeeInfoBean2) {
		if(employeeInfoBean != null) {
			//valid session
			if(service.addEmployee(employeeInfoBean2) ){
				modelMap.addAttribute("msg", "Record added successfully!!!");
			}else {
				modelMap.addAttribute("errMsg", "Unable to add the record Try again");
			}
			
			return "addEmpForm";			
		}else {
			//Invalid session
             modelMap.addAttribute("errMsg", "Please Login First ");
			
			return "empLoginForm";		
		}		
	}//End of addEmployee()
	
	@GetMapping("/updateEmpForm")
	public String  updateForm(HttpSession session,ModelMap modelMap) {
		
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login first...");
			return "empLoginForm";	
		}else {
			
			return "updateEmpForm";
		}
	}//ENd of updateForm()
	
	@PostMapping("/updateEmp")
	public String updateEmp(int empId,String name, @SessionAttribute(name = "loggedinEmpInfo",required = false)EmployeeInfoBean employeeInfoBean,ModelMap modelMap,HttpSession session,EmployeeInfoBean employeeInfoBean2) {
		
		if(session.getAttribute("loggedinEmpInfo") != null) {
			 if(service.updateEmployee(employeeInfoBean2)) {
				 modelMap.addAttribute("msg", "Employee is Updated successfully!!!");
			 }else {
				modelMap.addAttribute("errMsg", "Employee Details Not Found");
			}
			return "updateEmpForm";
		}else {
			modelMap.addAttribute("errMsg", "Please login first ...");
			return "empLoginForm";
		}
		
	}//End of updateEmp()
	
	@GetMapping("/getAllEmpForm")
	public String  getAllEmpForm(HttpSession session,ModelMap modelMap) {
		
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Please Login first...");
			return "empLoginForm";	
		}else {
			
			return "getAllEmployees";
		}
	}
	
	@GetMapping("/getAllEmp")
	public String getAllEmployees(@SessionAttribute(name = "loggedinEmpInfo",required = false)EmployeeInfoBean employeeInfoBean,HttpSession session, ModelMap modelMap) {
		
		if (employeeInfoBean != null) {
			//valid session
			List<EmployeeInfoBean> employeeInfoBeans1=service.getAllEmployee();
			if (employeeInfoBeans1 != null) {
				modelMap.addAttribute("employeeDetails", employeeInfoBeans1);
				
				
				return "getAllEmployees";			
			}else {
				modelMap.addAttribute("errMsg", "Employee details Not found!");
				
				return "getAllEmployees";
			}
			  
		}else {
			//Invalid Session
			modelMap.addAttribute("errMsg", "Please Login First...");
			
			return "empLoginForm";
		}
		
	}
	
	
	
	
	
	
	

}//End of controller
