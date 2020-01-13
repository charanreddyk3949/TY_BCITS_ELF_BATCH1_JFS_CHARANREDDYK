package com.bcits.jpawithhibernateapp.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp.manytoone.EmployeeAddressInfo;
import com.bcits.jpawithhibernateapp.manytoone.EmployeeAddressPK;
import com.bcits.jpawithhibernateappinsert.beans.EmployeePrimaryInfo;

public class TestManyToOne {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		EmployeePrimaryInfo test = new EmployeePrimaryInfo();
		
		test.setEmpid(21);
		test.setName("vignesh");
		test.setMobileno(99080392);
		test.setOfficialmailid("vignesh@gmail.com");
		test.setDateofjoining(java.sql.Date.valueOf("2016-09-19"));
		test.setDateofbirth(java.sql.Date.valueOf("1995-08-09"));
		test.setDesignation("clerk");
		test.setBloodgroup("b+");
		test.setSalary(43000);
		test.setDeptid(20);
		test.setManagerid(945);
		
		EmployeeAddressPK addressPK=new EmployeeAddressPK();
		addressPK.setEmpid(21);
		addressPK.setAddresstype("permanent");
		
		EmployeeAddressInfo addressInfo=new EmployeeAddressInfo();
		addressInfo.setAddressPK(addressPK);
		addressInfo.setHouseno(150);
		addressInfo.setAddress1("Hemanth nagar");
		addressInfo.setAddress2("Marathalli");
		addressInfo.setLandmark("kalamandir");
		addressInfo.setPincode(560078);
		addressInfo.setPrimaryInfo(test);
		
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			EmployeePrimaryInfo primaryInfo=manager.find(EmployeePrimaryInfo.class, 21);
			addressInfo.setPrimaryInfo(primaryInfo);
			
			manager.persist(addressInfo);
			System.out.println("Record is saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

	}// End of main
}// End of class
