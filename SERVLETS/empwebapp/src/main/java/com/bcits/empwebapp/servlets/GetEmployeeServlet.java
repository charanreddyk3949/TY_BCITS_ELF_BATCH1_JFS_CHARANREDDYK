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
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;
 
@WebServlet("/getEmployee")
public class GetEmployeeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//validate Session
		HttpSession session=req.getSession(false);
		PrintWriter out=resp.getWriter();
		if (session != null) {
		  //valid session	
		
		//Get Form data
		String empIdVal=req.getParameter("empId");
		int empId=Integer.parseInt(empIdVal);
		
		//Search record in DB
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("emsPersitenceUnit");
		EntityManager manager=emf.createEntityManager();
		
		EmployeePrimaryInfo primaryInfo=manager.find(EmployeePrimaryInfo.class, empId);
		
		//Generate the Dynamic response
		resp.setContentType("text/html");
		 
		
		if(primaryInfo != null) {
			//Display Em[ployee record
			EmployeePrimaryInfo loggedInEmpInfo=(EmployeePrimaryInfo)session.getAttribute("EmployeePrimaryInfo");
			
			// display the employee record
			out.println("<html>");
			out.println("<body>");
			
			out.println("<h1>Hello "+ loggedInEmpInfo.getName()+"!</h1>");
			out.println("<a href='./employeeHomePage.html'>HOME</a><br>");
			
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
		}else {
			
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color: red'>Please Login First!!</h1>");
			out.println("</body>");
			out.println("</html>");
			
			req.getRequestDispatcher("./loginForm.html").include(req, resp);
			
		}
		
	}//End of doGet

}// End of class
