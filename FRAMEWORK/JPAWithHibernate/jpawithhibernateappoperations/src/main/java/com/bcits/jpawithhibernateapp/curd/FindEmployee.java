package com.bcits.jpawithhibernateapp.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateappinsert.beans.EmployeePrimaryInfo;

public class FindEmployee {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("test");
		EntityManager manager=entityManagerFactory.createEntityManager();
		
	 EmployeePrimaryInfo info=manager.find(EmployeePrimaryInfo.class, 99);
		
//		EmployeePrimaryInfo info=manager.getReference(EmployeePrimaryInfo.class, 111);
	
		System.out.println(info.getClass());
		
		System.out.println("EmployeeId ----"+info.getEmpid());
		System.out.println("EmployeeName---"+info.getName());
		System.out.println("EmployeeOffmailid---"+info.getMobileno());
		System.out.println("EmployeeDOB---"+info.getDateofbirth());
		System.out.println("EmployeeDOJ---"+info.getDateofjoining());
		System.out.println("EmployeeDesignation---"+info.getDesignation());
		System.out.println("EmployeeBloodgroup---"+info.getBloodgroup());
		System.out.println("EmployeeSalary---"+info.getSalary());
		System.out.println("EmployeeDeptid---"+info.getDeptid());
	
		manager.close();
	}

}
