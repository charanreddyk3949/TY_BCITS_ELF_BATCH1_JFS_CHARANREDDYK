package com.bcits.jpawithhibernateapp.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp.onetoone.EmployeeSecondaryInfo;
import com.bcits.jpawithhibernateappinsert.beans.EmployeePrimaryInfo;

public class OneToOneBirectional {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;

		EmployeePrimaryInfo test = new EmployeePrimaryInfo();
		test.setEmpid(20);
		test.setName("dhoni");
		test.setMobileno(87909392);
		test.setOfficialmailid("msdhoni@gmail.com");
		test.setDateofjoining(java.sql.Date.valueOf("2018-12-09"));
		test.setDateofbirth(java.sql.Date.valueOf("1998-12-09"));
		test.setDesignation("tester");
		test.setBloodgroup("o+");
		test.setSalary(300000);
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
		test.setSecondaryInfo(secondaryInfo);
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
//			manager.persist(test);
			EmployeePrimaryInfo info=manager.find(EmployeePrimaryInfo.class, 19);
			System.out.println(info.getDesignation());
			System.out.println(info.getSecondaryInfo().getIsmarried());
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
