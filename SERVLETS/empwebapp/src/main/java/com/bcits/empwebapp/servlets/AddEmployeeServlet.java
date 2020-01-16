package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String empIdVal = req.getParameter("empId");
		String nameVal = req.getParameter("name");
		String salaryVal = req.getParameter("salary");
		String mobileNoVal = req.getParameter("mobileNo");
		String passwordval = req.getParameter("password");
		String dateOfJoiningVal = req.getParameter("dateOfJoining");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date joiningDate = null;
		try {
			joiningDate = dateFormat.parse("joiningDateVal");
		} catch (ParseException e) {

			e.printStackTrace();
		}

		EmployeePrimaryInfo primaryInfo = new EmployeePrimaryInfo();
		primaryInfo.setEmpId(Integer.parseInt(empIdVal));
		primaryInfo.setName(nameVal);
		primaryInfo.setSalary(Integer.parseInt(salaryVal));
		primaryInfo.setMobileNo(Integer.parseInt(mobileNoVal));
		primaryInfo.setPassword(passwordval);
		primaryInfo.setDateOfJoining(joiningDate);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersitenceUnit");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(primaryInfo);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		manager.close();
		emf.close();

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<body>");
		if (isAdded) {
			out.println("<h1 style='color:green'>Employee Record for Id  " + empIdVal + " Indserted</h1>");
		} else {
			out.println("<h1 style='color:red'>Unable to insert the Record");
		}
		out.println("</body>");
		out.println("</html>");

	}// End of dopost
}// End od Class
