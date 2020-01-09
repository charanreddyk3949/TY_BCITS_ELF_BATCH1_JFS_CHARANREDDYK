package com.bcits.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp.bean.Test;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
    	
    	Test test= new Test();
    	test.setMid(1);
    	test.setMovieName("Bahubali");
    	test.setMovieRating("Excellent");
    	
    	
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
