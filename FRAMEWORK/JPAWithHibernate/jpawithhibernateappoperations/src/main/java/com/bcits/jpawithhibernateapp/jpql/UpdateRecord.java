package com.bcits.jpawithhibernateapp.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateRecord {
	public static void main(String[] args) {
		
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try {
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("test");
			manager = factory.createEntityManager();
			 transaction=manager.getTransaction();
			 transaction.begin();
			String jpql="update EmployeePrimaryInfo set name='ganesh' where empid = 2";
			Query query=manager.createQuery(jpql);
			int count=query.executeUpdate();
			
			System.out.println("No of rows affected===="+count);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			manager.close();
		}
		
		
	}

}
