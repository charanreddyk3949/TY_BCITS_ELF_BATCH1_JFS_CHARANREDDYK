package com.bcits.jpawithhibernateapp.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bcits.jpawithhibernateappinsert.beans.EmployeePrimaryInfo;

public class ReadName {
	public static void main(String[] args) {
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("test");
		EntityManager manager=factory.createEntityManager();
		String jpql="select name from EmployeePrimaryInfo ";
		Query query=manager.createQuery(jpql);
		List<String> list=query.getResultList();
		for (String info : list) {
			
			System.out.println("EmployeeName---"+info);
		
		}
	}

}
