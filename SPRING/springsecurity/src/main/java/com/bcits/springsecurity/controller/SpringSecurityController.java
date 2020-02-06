package com.bcits.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringSecurityController {
	
	@GetMapping("/index")
	public String getIndexPage() {
		return "index";
	}
	
	@GetMapping("/adminSecureHome")
	public String getAdminPage() {
		return "adminHomePage";
	}
	
	@GetMapping("/userSecureHome")
	public String getUserPage() {
		return "userHomePage";
	}
	
	@GetMapping("/login")
	public String getLoginFormPage() {
		return "loginForm";
	}

}//End of Controller
