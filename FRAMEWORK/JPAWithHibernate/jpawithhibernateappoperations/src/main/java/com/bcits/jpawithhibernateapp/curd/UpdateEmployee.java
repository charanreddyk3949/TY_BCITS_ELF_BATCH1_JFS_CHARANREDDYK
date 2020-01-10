package com.bcits.jpawithhibernateapp.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateappinsert.beans.EmployeePrimaryInfo;

public class UpdateEmployee {
	public static void main(String[] args) {
		EntityTransaction transaction = null;
		EntityManager manager = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			EmployeePrimaryInfo info = manager.find(EmployeePrimaryInfo.class, 1);
			info.setSalary(50000);
			transaction.commit();
			System.out.println("Record is updated");
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			manager.close();
		}

	}// End of main

}// End of class
