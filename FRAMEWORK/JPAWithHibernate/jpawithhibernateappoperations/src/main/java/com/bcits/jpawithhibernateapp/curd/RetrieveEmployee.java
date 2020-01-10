package com.bcits.jpawithhibernateapp.curd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateappinsert.beans.EmployeePrimaryInfo;

public class RetrieveEmployee {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("test");
		EntityManager manager=entityManagerFactory.createEntityManager();
		EmployeePrimaryInfo info=manager.find(EmployeePrimaryInfo.class, 5);
		
		System.out.println("EmployeeId ----"+info.getEmpid());
		System.out.println("EmployeeName---"+info.getName());
		System.out.println("EmployeeOfficialmailid---"+info.getMobileno());
		System.out.println("EmployeeDOB---"+info.getDateofbirth());
		System.out.println("EmployeeDOJ---"+info.getDateofjoining());
		System.out.println("EmployeeDesignation---"+info.getDesignation());
		System.out.println("EmployeeBloodgroup---"+info.getBloodgroup());
		System.out.println("EmployeeSalary---"+info.getSalary());
		System.out.println("EmployeeDeptid---"+info.getDeptid());
		
	}
	
}
