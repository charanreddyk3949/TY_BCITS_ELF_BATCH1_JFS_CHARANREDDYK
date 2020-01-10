package com.bcits.jpawithhibernateapp.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import com.bcits.jpawithhibernateappinsert.beans.EmployeePrimaryInfo;

public class DeleteEmployee {
	public static void main(String[] args) {
		EntityTransaction transaction = null;
		EntityManager manager = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			EmployeePrimaryInfo info = manager.find(EmployeePrimaryInfo.class, 66);
			manager.remove(info);
			transaction.commit();
			System.out.println("Record is deleted");
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			manager.close();
		}

	}

}
