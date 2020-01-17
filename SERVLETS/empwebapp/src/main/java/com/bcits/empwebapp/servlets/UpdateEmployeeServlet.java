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

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String empIdVal=req.getParameter("empId");
		int empId=Integer.parseInt(empIdVal);
		String name=req.getParameter("name");
//		String designation=req.getParameter("designation");
//		String password=req.getParameter("password");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("emsPersitenceUnit");
		EntityManager manager=emf.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		EmployeePrimaryInfo info=null;
		try {
			info=manager.find(EmployeePrimaryInfo.class, empId);
			info.setName(name);
//			info.setDesignation(designation);
//			info.setPassword(password);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
		PrintWriter out=resp.getWriter();
		if(info !=null) {
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:green'>Employee with ID"+empId+" Updated Successfully!!!</h1>");
			out.println("</body>");
			out.println("</html>");
			
		}else {
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color:red'>Employee Det"
					+ "ails not Found</h1>");
			out.println("</body>");
			out.println("</html>");
			
		}
		manager.close();
		emf.close();
	}

}
