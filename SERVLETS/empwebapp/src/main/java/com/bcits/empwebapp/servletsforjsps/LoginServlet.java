package com.bcits.empwebapp.servletsforjsps;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;


@WebServlet("/login2")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empIdVal=Integer.parseInt(req.getParameter("empId"));
		String password=req.getParameter("password");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("emsPersitenceUnit");
		EntityManager manager=emf.createEntityManager();
		
		String jpql="from EmployeePrimaryInfo where empId=:empId and password=:pwd";
		Query query=manager.createQuery(jpql);
		query.setParameter("empId", empIdVal);
		query.setParameter("pwd", password);
		
		EmployeePrimaryInfo employeePrimaryInfo=null;
		try {
			employeePrimaryInfo=(EmployeePrimaryInfo)query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(employeePrimaryInfo != null) {
			//Valid credentials
			HttpSession session=req.getSession(true);
			session.setAttribute("loggedInEmpInfo", employeePrimaryInfo);
			
			req.getRequestDispatcher("./homePage.jsp").forward(req, resp);
			
		}else {
			//Invalid Credentials
			req.setAttribute("msg", "Invalid Employee ID/Password");
			req.getRequestDispatcher("./loginForm.jsp").forward(req, resp);
			
		}
	}

}
