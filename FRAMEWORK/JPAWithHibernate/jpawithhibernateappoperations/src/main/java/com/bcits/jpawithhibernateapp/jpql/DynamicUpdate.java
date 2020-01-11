package com.bcits.jpawithhibernateapp.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicUpdate {
	public static void main(String[] args) {
		
		EntityManager manager=null;
		EntityTransaction transaction=null;
		try {
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("test");
			manager = factory.createEntityManager();
			 transaction=manager.getTransaction();
			 transaction.begin();
			String jpql="update EmployeePrimaryInfo set name=:nm where empid =:id";
			Query query=manager.createQuery(jpql);
			query.setParameter("id", 9);
			query.setParameter("nm", "umesh");
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
