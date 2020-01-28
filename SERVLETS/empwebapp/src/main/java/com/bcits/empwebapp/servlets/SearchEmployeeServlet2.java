package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;
 
@WebServlet("/findEmployee")
public class SearchEmployeeServlet2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Get Form data
		String empIdVal=req.getParameter("empId");
		int empId=Integer.parseInt(empIdVal);
		
		//Search record in DB
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("emsPersitenceUnit");
		EntityManager manager=emf.createEntityManager();
		
		EmployeePrimaryInfo primaryInfo=manager.find(EmployeePrimaryInfo.class, empId);
		
		//Generate the Dynamic response
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		if(primaryInfo != null) {
			// display the employee record
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:green'>Employee ID "+empId+" Found </h1> ");
			out.println("<br><br>Name = "+primaryInfo.getName());
			out.println("<br><br>Salary = "+primaryInfo.getSalary());
			out.println("<br><br>Date of birth ="+primaryInfo.getDateOfBirth());
			out.println("<br><br>Designation ="+primaryInfo.getDesignation());
			out.println("<br><br>Official Mail ID ="+primaryInfo.getOfficialMailid());
			out.println("</body>");
			out.println("</html>");
			
		}else {
			//Display employee not Found
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color: red'>EmployeeID "+empId+" Not Found!!!</h1>");
			out.println("</body>");
			out.println("</html>");
		
		}
		manager.close();
		emf.close();
		
	}//End of doGet

}// End of class
