package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {
	
	public DateServlet() {
		System.out.println("Its instantiation phase");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("Its initialization phase");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//java code to generate current date and time 
		Date date=new Date();
		
		ServletConfig config=getServletConfig();
		String myConfigParamVal=config.getInitParameter("servletName");  //(config param)
		
		
		ServletContext context=getServletContext();
		String myContexParamVal=context.getInitParameter("appName");  //(contex param                                                                      )
		
		
		//code to generate dynamic response
		resp.setContentType("text/html");
		
		//refresh the time for each 1 second
		resp.setHeader("refresh", "1");
		
		
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Current system Date & Time is :-"+date+"</h1>");
		
		out.print("<h2>Servelet Name=  "+myConfigParamVal +"</h2>");         // (config param)
		out.print("</h1>appName= "+myContexParamVal+"</h1>");             //(contex param)
		out.println("</body>");
		out.println("</html>");
		
		
	}//End od doGet
@Override
public void destroy() {
	System.out.println("Its Destruction face");
}	

}//End of class
