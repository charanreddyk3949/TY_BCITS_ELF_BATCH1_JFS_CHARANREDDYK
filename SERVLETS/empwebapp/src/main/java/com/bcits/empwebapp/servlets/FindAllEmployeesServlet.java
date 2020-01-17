package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;



@WebServlet("/findAllEmployees")
public class FindAllEmployeesServlet extends HttpServlet{
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
		 
		 
	    EntityManagerFactory factory=Persistence.createEntityManagerFactory("emsPersitenceUnit");
		EntityManager manager=factory.createEntityManager();
		String jpql = " from EmployeePrimaryInfo";
		Query query = manager.createQuery(jpql);
		List<EmployeePrimaryInfo> list = query.getResultList();
		PrintWriter out = resp.getWriter();
		for (EmployeePrimaryInfo employeePrimaryInfo : list) {
			out.println("<html>");
			out.println("<body>");
			out.println("Employee Id:"+employeePrimaryInfo.getEmpId());
			out.println("Employee Id:"+employeePrimaryInfo.getEmpId());
			out.println("Name:"+employeePrimaryInfo.getName());
			out.println("Designation:"+employeePrimaryInfo.getDesignation());
			out.println("Salary:"+employeePrimaryInfo.getSalary());
			
			out.println("</body>");
			out.println("</html>");
		}
    
	}

}
