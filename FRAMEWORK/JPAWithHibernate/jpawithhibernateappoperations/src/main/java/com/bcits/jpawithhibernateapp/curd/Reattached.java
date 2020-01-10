package com.bcits.jpawithhibernateapp.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sound.midi.MidiDevice.Info;

import com.bcits.jpawithhibernateappinsert.beans.EmployeePrimaryInfo;

public class Reattached {
	public static void main(String[] args) {
		
		EntityManager manager=null;
		EntityTransaction  transaction=null;
		try {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction=manager.getTransaction();
			transaction.begin();
			EmployeePrimaryInfo info=manager.find(EmployeePrimaryInfo.class, 1);
			System.out.println(manager.contains(info));
			manager.detach(info);
			System.out.println(manager.contains(info));
			EmployeePrimaryInfo reattach=manager.merge(info);///merge method helps to reattach the detached objects 
			reattach.setDesignation("software developer");
			System.out.println("Executed");
			
			transaction.commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		manager.close();
	}//End of main

}//End of class
