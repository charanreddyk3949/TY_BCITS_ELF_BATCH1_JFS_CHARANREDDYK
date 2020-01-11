package com.bcits.jpawithhibernateapp.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import com.bcits.jpawithhibernateappinsert.beans.EmployeePrimaryInfo;

public class ReadEmployee {
	public static void main(String[] args) {
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("test");
		EntityManager manager=factory.createEntityManager();
		String jpql=" from EmployeePrimaryInfo";
		Query query=manager.createQuery(jpql);
		List<EmployeePrimaryInfo> list=query.getResultList();
		for (EmployeePrimaryInfo info : list) {
			System.out.println("EmployeeId ----"+info.getEmpid());
			System.out.println("EmployeeName---"+info.getName());
			System.out.println("EmployeeOffmailid---"+info.getMobileno());
			System.out.println("EmployeeDOB---"+info.getDateofbirth());
			System.out.println("EmployeeDOJ---"+info.getDateofjoining());
			System.out.println("EmployeeDesignation---"+info.getDesignation());
			System.out.println("EmployeeBloodgroup---"+info.getBloodgroup());
			System.out.println("EmployeeSalary---"+info.getSalary());
			System.out.println("EmployeeDeptid---"+info.getDeptid());
			System.out.println("EmployeeManagerId--"+info.getManagerid());
			System.out.println("--------------------------------------------------------");
			
			
		}
	}

}
