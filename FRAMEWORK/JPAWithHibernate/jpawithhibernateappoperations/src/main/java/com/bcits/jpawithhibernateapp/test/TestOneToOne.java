package com.bcits.jpawithhibernateapp.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp.onetoone.EmployeeSecondaryInfo;
import com.bcits.jpawithhibernateappinsert.beans.EmployeePrimaryInfo;

public class TestOneToOne {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;

		EmployeePrimaryInfo test = new EmployeePrimaryInfo();
		test.setEmpid(19);
		test.setName("vinay");
		test.setMobileno(94849392);
		test.setOfficialmailid("anusha@gmail.com");
		test.setDateofjoining(java.sql.Date.valueOf("2017-12-09"));
		test.setDateofbirth(java.sql.Date.valueOf("1997-12-09"));
		test.setDesignation("tester");
		test.setBloodgroup("o+");
		test.setSalary(30000);
		test.setDeptid(40);
		test.setManagerid(563);
		
		EmployeeSecondaryInfo secondaryInfo=new EmployeeSecondaryInfo();
		secondaryInfo.setGender("male");
		secondaryInfo.setPersonalmailid("shankarkumar@gmail.com");
		secondaryInfo.setAge(29);
		secondaryInfo.setNationality("Indian");
		secondaryInfo.setIsmarried("no");
		secondaryInfo.setGovtid("Adhaar");
		secondaryInfo.setGuardianname("Shankar");
		secondaryInfo.setGuardiancontactno(786484448);
		secondaryInfo.setJoblocation("mumbai");
		secondaryInfo.setPrimay(test);
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(secondaryInfo);
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
