package com.bcits.jpawithhibernateapp.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateappinsert.beans.EmployeePrimaryInfo;

public class InsertEmployee {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;

		EmployeePrimaryInfo test = new EmployeePrimaryInfo();
		test.setEmpid(17);
		test.setName("anu");
		test.setMobileno(94849392);
		test.setOfficialmailid("anusha@gmail.com");
		test.setDateofjoining(java.sql.Date.valueOf("2017-12-09"));
		test.setDateofbirth(java.sql.Date.valueOf("1997-12-09"));
		test.setDesignation("tester");
		test.setBloodgroup("o+");
		test.setSalary(30000);
		test.setDeptid(30);

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(test);
			System.out.println("Record is saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

	}// End of main
}// End of class
