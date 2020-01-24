package com.bcits.springmvcs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bcits.springmvcs.bean.UserBean;

@Controller
public class SpringMVCController {
	
	@RequestMapping(path = "/hello",method = RequestMethod.GET)
	 public ModelAndView displayWelcomeMessage() {
		 ModelAndView modelAndView=new ModelAndView();
//		 modelAndView.setViewName("/WEB-INF/views/message.jsp");  //This is for InternalResourceViewResolver is not configured
		 modelAndView.setViewName("message");
		 
		 return modelAndView;
	 }//End of displayWelcomeMessage()
	
	@RequestMapping(path = "/searchEmployee",method = RequestMethod.GET)
	public ModelAndView searchEmployee(HttpServletRequest req) {
		 String empIdVal=req.getParameter("empId");
		 
		 ModelAndView modelAndView=new ModelAndView();
//		 modelAndView.setViewName("/WEB-INF/views/searchEmployee.jsp");  //This is for InternalResourceViewResolver is not configured
		 
		 modelAndView.setViewName("searchEmployee");
		 req.setAttribute("empId", empIdVal);
		 
		 return modelAndView;
	}//End of searchEmployee()
	
	@RequestMapping(path = "/loginForm",method = RequestMethod.GET)
    public ModelAndView displayLoginForm(ModelAndView modelAndView) {
		
//		ModelAndView modelAndView=new ModelAndView();
//		modelAndView.setViewName("/WEB-INF/views/loginForm.jsp");
		modelAndView.setViewName("loginForm");
		
		return modelAndView;
	}//End of displayLoginForm()
	
	//First method to get Form Data
	@RequestMapping(path = "/login1",method = RequestMethod.POST)
	public ModelAndView login1(HttpServletRequest req, ModelAndView modelAndView) {
		String empIdVal=req.getParameter("empId");
		int empId=Integer.parseInt(empIdVal);
		String password=req.getParameter("password");
		
		modelAndView.addObject("empId", empId);
		modelAndView.addObject("pwd", password);
		
//		modelAndView.setViewName("/WEB-INF/views/userDetails.jsp");
		
		modelAndView.setViewName("userDetails");
		return modelAndView;
	}//End of login1()
	
  //Second method to get the Form Details
	@PostMapping("/login2")
	public ModelAndView login2(@RequestParam(name="empId") int empId, 
			@RequestParam(name="password") String password , ModelAndView modelAndView) {
		
		modelAndView.addObject("empId", empId);
		modelAndView.addObject("pwd", password);
//		modelAndView.setViewName("/WEB-INF/views/userDetails.jsp");
		modelAndView.setViewName("userDetails");
		
		return modelAndView;
		
	}//End of login2()
	
  //Third method to get the form Details
	@PostMapping("/login3")
	public  String login3(int empId, String password, ModelMap modelMap) {  //Scope of ModelMap and HTTPServletRequest is same i.e..request
		modelMap.addAttribute("empId", empId);
		modelMap.addAttribute("pwd", password);
		
//		return "/WEB-INF/views/userDetails.jsp";
		
		return "userDetails";
		
	}//End of login3()
	
    @PostMapping("/login4")
	public String login4(UserBean userBean, ModelMap modelMap) {
		modelMap.addAttribute("userBean", userBean);
		
//		return "/WEB-INF/views/userDetails2.jsp";
		
		return "userDetails2";
		
	}//End of login4()
    
    //Adding extra fields 
    @PostMapping("/login5")
	public String login4(UserBean userBean,String name, ModelMap modelMap) {
		modelMap.addAttribute("userBean", userBean);
		modelMap.addAttribute("name", name);
		
//		 return "/WEB-INF/views/userDetails2.jsp";   //This is for InternalResourceViewResolver is not configured
		
		return "userDetails2";
	}//End of login4()
	
}//End of class
