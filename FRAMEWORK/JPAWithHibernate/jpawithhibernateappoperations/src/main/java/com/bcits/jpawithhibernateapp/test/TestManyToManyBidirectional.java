package com.bcits.jpawithhibernateapp.test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernateapp.manytomany.ProjectInfo;
import com.bcits.jpawithhibernateappinsert.beans.EmployeePrimaryInfo;

public class TestManyToManyBidirectional {
	public static void main(String[] args) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		EmployeePrimaryInfo test = new EmployeePrimaryInfo();

		test.setEmpid(24);
		test.setName("arjun");
		test.setMobileno(98666458);
		test.setOfficialmailid("arjunkumar@gmail.com");
		test.setDateofjoining(java.sql.Date.valueOf("2017-10-19"));
		test.setDateofbirth(java.sql.Date.valueOf("1995-01-19"));
		test.setDesignation("manager");
		test.setBloodgroup("ab+");
		test.setSalary(53000);
		test.setDeptid(40);
		test.setManagerid(765);

		EmployeePrimaryInfo test1 = new EmployeePrimaryInfo();

		test1.setEmpid(25);
		test1.setName("balaji");
		test1.setMobileno(77880392);
		test1.setOfficialmailid("balaji@gmail.com");
		test1.setDateofjoining(java.sql.Date.valueOf("2019-09-19"));
		test1.setDateofbirth(java.sql.Date.valueOf("1995-06-09"));
		test1.setDesignation("tester");
		test1.setBloodgroup("o+");
		test1.setSalary(45000);
		test1.setDeptid(10);
		test1.setManagerid(445);

		ArrayList<EmployeePrimaryInfo> alempEmployeePrimaryInfos = new ArrayList<EmployeePrimaryInfo>();
		alempEmployeePrimaryInfos.add(test);
		alempEmployeePrimaryInfos.add(test1);

		ProjectInfo projectInfo = new ProjectInfo();
		projectInfo.setProjid(12);
		projectInfo.setProjname("elctrical");
		projectInfo.setTechnology("java");
		projectInfo.setStartdate(java.sql.Date.valueOf("2018-09-19"));
		projectInfo.setEnddate(java.sql.Date.valueOf("2021-06-09"));
		projectInfo.setLocation("Banglore");
		projectInfo.setPrimaryInfos(alempEmployeePrimaryInfos);

		ProjectInfo projectInfo1 = new ProjectInfo();
		projectInfo1.setProjid(13);
		projectInfo1.setProjname("elctrical");
		projectInfo1.setTechnology("java");
		projectInfo1.setStartdate(java.sql.Date.valueOf("2018-09-19"));
		projectInfo1.setEnddate(java.sql.Date.valueOf("2021-06-09"));
		projectInfo1.setLocation("Banglore");
		projectInfo1.setPrimaryInfos(alempEmployeePrimaryInfos);
		ArrayList<ProjectInfo> alpProjectInfos = new ArrayList<ProjectInfo>();
		alpProjectInfos.add(projectInfo);
		alpProjectInfos.add(projectInfo1);

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(test);
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
