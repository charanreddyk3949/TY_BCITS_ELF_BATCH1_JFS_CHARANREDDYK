package com.bcits.empwebapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String url="https://www.youtube.com";
		
		String url="http://localhost:8080/empwebapp/currentDate";
		
//		String url="http://localhost:8080/empwebapp/date.html";
		
		resp.sendRedirect(url);
	}//End of doGet

}//End of class
