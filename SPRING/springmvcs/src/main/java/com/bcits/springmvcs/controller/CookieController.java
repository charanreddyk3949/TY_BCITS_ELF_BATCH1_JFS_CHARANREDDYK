package com.bcits.springmvcs.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class CookieController {
	
	@GetMapping("/cookiePage")
	public String getCookie() {
		return "cookiePage";
		
	}//End of getCookie()
	
	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse resp, ModelMap modelMap) {

		
		Cookie myCookie=new Cookie("empName", "charan");
		resp.addCookie(myCookie);
		
		modelMap.addAttribute("msg", "Cookie Created successfully...");
		return "cookiePage";
	}//End of createCoookie()
	
	@GetMapping("/readCookie")
	public String readCookie(@CookieValue(name= "empName", required = false) String employeeName, ModelMap modelMap) {
	   if (employeeName != null) {
		   modelMap.addAttribute("msg", "Cookie value is "+employeeName);
	   }else {
		   modelMap.addAttribute("errMsg", "Cookie not present!");
	}
		
	 
	 return "cookiePage";
		
	}//End of readCookie()

}//ENd of class
