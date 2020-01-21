package com.bcits.bcitsusecase.dbcreation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.bcitsusecase.beans.ConsumersMaster;

 @WebServlet("/addConsumer")
public class ComsumersMasterServlet extends HttpServlet{
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
		String firstName=req.getParameter("firstName");
		String lastName=req.getParameter("lastName");
		String email=req.getParameter("email");
		String address1=req.getParameter("address1");
		String address2=req.getParameter("address2");
		String city=req.getParameter("city");
		String state=req.getParameter("state");
		String pinCodeVal=req.getParameter("pinCode");	
		int pinCode=Integer.parseInt(pinCodeVal);
		String region=req.getParameter("region");
		String consumerType=req.getParameter("consumerType");
		String meterNumber=req.getParameter("meterNumber");
		String password=req.getParameter("password");
		String confirmPassword=req.getParameter("confirmPassword");
		
		ConsumersMaster consumer=new ConsumersMaster();
		consumer.setFirstName(firstName);
		consumer.setLastName(lastName);
		consumer.setEmail(email);
		consumer.setAddress1(address1);
		consumer.setAddress2(address2);
		consumer.setCity(city);
		consumer.setState(state);
		consumer.setState(state);
		consumer.setPinCode(pinCode);
		consumer.setRegion(region);
		consumer.setConsumerType(consumerType);
		consumer.setMeterNumber(meterNumber);
		consumer.setMeterNumber(meterNumber);
		consumer.setPassword(confirmPassword);
		consumer.setConfirmPassword(confirmPassword);
		
//		ConsumersMaster consumer=new ConsumersMaster();
//		
//		consumer.setFirstName("charan");
//		consumer.setLastName("reddy");
//		consumer.setEmail("charan123@gmail.com");
//		consumer.setAddress1("1-50,svvs");
//		consumer.setAddress2("marathalli");
//		consumer.setCity("Banglore");
//		consumer.setState("karnataka");
//		consumer.setPinCode(517408);
//		consumer.setRegion("banglore south");
//		consumer.setConsumerType("residential");
//		consumer.setMeterNumber("ERT1234");
//		consumer.setPassword("qwerty");
//		consumer.setConfirmPassword("qwerty");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("discomPersitenceUnit");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded=false;
		try {
			transaction.begin();
			manager.persist(consumer);
			transaction.commit();
			isAdded=true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		
		out.println("<html>");
		out.println("<body>");
		if (isAdded) {
			out.println("<h1 style='color:green'>Consumer is registered Succesfully!!!</h1>");
		} else {
			out.println("<h1 style='color:red'>Unable register please fill the form again!!!");
		}
		
		out.println("</body>");
		out.println("</html>");
		
		
		manager.close();
		emf.close();
	}//End of doPost

}//End of class
