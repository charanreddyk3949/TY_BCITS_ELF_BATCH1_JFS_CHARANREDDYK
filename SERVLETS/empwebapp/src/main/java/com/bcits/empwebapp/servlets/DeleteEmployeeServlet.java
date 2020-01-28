package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;
@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
		String empIdVal=req.getParameter("empId");
		int empId=Integer.parseInt(empIdVal);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("emsPersitenceUnit");
		EntityManager manager=emf.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		EmployeePrimaryInfo primaryInfo=null;
		try {
			primaryInfo = manager.find(EmployeePrimaryInfo.class, empId);
			manager.remove(primaryInfo);
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		if(primaryInfo != null) {
			// display the employee record
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:green'>Employee ID "+empId+" Deleted </h1> ");
			out.println("</body>");
			out.println("</html>");
			
		}else {
			//Display employee not Found
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color: red'>Unable to delete!!!</h1>");
			out.println("</body>");
			out.println("</html>");
		
		}
		manager.close();
		emf.close();
		
	}//End of doGet

}// End of class