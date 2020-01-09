package com.bcits.jpawithhibernateappinsert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import com.bcits.jpawithhibernateappinsert.beans.Test;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Test test=new Test();
    	test.setEmpid(16);
    	test.setName("anu");
    	test.setMobileno(94849392);
    	test.setOfficialmailid("anusha@gmail.com");
    	test.setDateofjoining(java.sql.Date.valueOf("2017-12-09"));
    	test.setDateofbirth(java.sql.Date.valueOf("1997-12-09"));
    	test.setDesignation("tester");
    	test.setBloodgroup("o+");
    	test.setSalary(30000);
    	test.setDeptid(30);
    	test.setManagersal(10000);
    	
    	
    	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("test");
    	EntityManager manager=entityManagerFactory.createEntityManager();
    	EntityTransaction transaction=manager.getTransaction();
    	transaction.begin();
    	manager.persist(test);
    	System.out.println("Record is saved");
    	transaction.commit();
    	manager.close();
    	
    	
       
    }
}
