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
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.service.ConsumerService;


@Controller
@RequestMapping("/consumer")
public class ConsumerController {
	
	@Autowired
	 private ConsumerService service;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);	
	}//End of initBinder()
	
	@GetMapping("/homePage")
	public String displayHomePage() {
		
		return "homePage";
		
	}//End of homePage()
	
	@GetMapping("/consumerLogin")
	public String displayForm() {
		
		return "consumerLogin";
		
	}//End of displayForm()
	
	
	
	@GetMapping("/consumerSignup")
	public String displayConsumerSignup() {
		
		return "consumerSignup";
		
	}//End of homePage()
	
	@GetMapping("/paymentPage")
	public String displayPaymentPage() {
		
		return "paymentPage";
		
	}//End of paymentPage()
	
	
	@PostMapping("/login")
	public String authenticate(String rrNumber, String password,HttpServletRequest req, ModelMap modelMap) {
//		EmployeeDAO dao =new EmployeeDAOHibernateImpl();
		ConsumersMasterBean consumersMasterBean=service.authenticate(rrNumber, password);
		ConsumersMasterBean masterBean=service.getConsumer(rrNumber);
		if (consumersMasterBean != null) {
			//Valid credentials
			HttpSession session= req.getSession(true);
			session.setAttribute("loggedinEmpInfo", consumersMasterBean);
			session.setAttribute("consumerDetails", masterBean);
			return "consumerHome";	
		}else {
			//Invalid credentials
			modelMap.addAttribute("errMsg", "Invalid Credentials");
			return "consumerLogin";
		}
	}//End of authenticate()
	
	
	@PostMapping("/addConsumer")
	public String addEmployee(@SessionAttribute(name = "loggedinEmpInfo",required = false) ConsumersMasterBean consumersMasterBean,ModelMap modelMap, ConsumersMasterBean consumersMasterBean2) {
		if(consumersMasterBean != null) {
			//valid session
			if(service.addConsumer(consumersMasterBean2) ){
				modelMap.addAttribute("msg", "SignUp Successfully (: Please Login now");
			}else {
				modelMap.addAttribute("errSignupMsg", "SignUp Failed Please try Again");
			}
			return "consumerLogin";			
		}else {
			//Invalid session
             modelMap.addAttribute("errMsg", "Please Login First ");
			
			return "consumerLogin";		
		}		
	}//End of addConsumer()
	
	@PostMapping("/updateConsumer")
	public String updateEmp(int rrNumber,String firstName, @SessionAttribute(name = "loggedinEmpInfo",required = false)ConsumersMasterBean consumersMasterBean,ModelMap modelMap,HttpSession session,ConsumersMasterBean consumersMasterBean2) {
		
		if(consumersMasterBean != null) {
			 if(service.updateConsumer(consumersMasterBean2)) {
				 modelMap.addAttribute("msg", "Consumer is Updated successfully!!!");
			 }else {
				modelMap.addAttribute("errMsg", "Consumer Details Not Found");
			}
			return "updateEmpForm";
		}else {
			modelMap.addAttribute("errMsg", "Please login first ...");
			return "consumerLogin";
		}
		
	}//End of updateEmp()
	
	@GetMapping("/delete")
	public String  deleteConsumer(int rrNumber,
			@SessionAttribute(name = "loggedinEmpInfo",required = false)ConsumersMasterBean consumersMasterBean,ModelMap modelMap) {
		
		if(consumersMasterBean != null) {
		   // valid
			if(service.deleteConsumer(rrNumber)) {
				modelMap.addAttribute("msg", "Consumer Record is Deleted Successfully!");
			}else {
				modelMap.addAttribute("errMsg", "Consumer Id not Found!");
			}
			
			return "consumerLogin";
		}else {
			modelMap.addAttribute("errMsg", "Please Login first");
			return "consumerLogin";
		}
	}// End of DeleteConsumer()
	
	
//	@GetMapping("/search")
//	public String searchConsumer(int rrNumber, HttpSession session,ModelMap modelMap) {
//		
//		if (session.getAttribute("loggedinEmpInfo") != null) {
//			//Valid Session
//			
//			ConsumersMasterBean consumersMasterBean= service.getConsumer(rrNumber);
//			
//			if (consumersMasterBean != null) {
//				modelMap.addAttribute("consumersMasterBean", consumersMasterBean);
//				
//			}else {
//				modelMap.addAttribute("errMsg", "Consumer Not found");
//			}
//			return "searchConsumer";
//		}else {
//			
//			modelMap.addAttribute("errMsg", "Please Login First");
//			
//			return "consumerLogin";
//		}
//	}//End of searchConsumer
	
	
	@GetMapping("/getAllConsumers")
	public String getAllConsumers(@SessionAttribute(name = "loggedinEmpInfo",required = false)ConsumersMasterBean consumersMasterBean,HttpSession session, ModelMap modelMap) {
		
		if (consumersMasterBean != null) {
			//valid session
			List<ConsumersMasterBean> consumersMasterBeans1=service.getAllConsumers();
			if (consumersMasterBeans1 != null) {
				modelMap.addAttribute("employeeDetails", consumersMasterBeans1);
				
				
				return "getAllEmployees";			
			}else {
				modelMap.addAttribute("errMsg", "Consumer details Not found!");
				
				return "getAllConsumers";
			}
			  
		}else {
			//Invalid Session
			modelMap.addAttribute("errMsg", "Please Login First...");
			
			return "consumerLogin";
		}
	}//End of getAllConsumers
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session,ModelMap modelMap  ) {
		session.invalidate();
		modelMap.addAttribute("errMsg", "you are logged out successfully!!");
		
		return "consumerLogin";
	}//End of logged out
	
	
	
}//End of Class
