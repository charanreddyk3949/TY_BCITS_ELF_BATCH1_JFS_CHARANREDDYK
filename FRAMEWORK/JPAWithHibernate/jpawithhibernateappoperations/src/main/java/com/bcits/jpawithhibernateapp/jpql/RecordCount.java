package com.bcits.jpawithhibernateapp.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RecordCount {
	public static void main(String[] args) {
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try {
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("test");
			manager = factory.createEntityManager();
			 transaction=manager.getTransaction();
			 transaction.begin();
			String jpql="select count(name) from EmployeePrimaryInfo";
			Query query=manager.createQuery(jpql);
			int count=(Integer) query.getSingleResult();
			
			System.out.println("Count =="+count);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			manager.close();
		}
		
		
	}

}
