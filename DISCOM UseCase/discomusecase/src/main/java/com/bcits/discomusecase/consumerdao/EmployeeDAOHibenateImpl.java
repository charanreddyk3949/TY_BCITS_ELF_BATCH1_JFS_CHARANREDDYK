package com.bcits.discomusecase.consumerdao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.EmployeeMaster;


@Repository
public class EmployeeDAOHibenateImpl implements EmployeeDAO{
	
	@PersistenceUnit 
	private EntityManagerFactory factory;

	@   Override
	public EmployeeMaster authenticate(Integer empId, String password) {
		
		EntityManager manager=factory.createEntityManager();
		EmployeeMaster employeeMaster=manager.find(EmployeeMaster.class, empId);
		if(employeeMaster != null && employeeMaster.getPassword().equals(password)) {
			return employeeMaster;
		}else {
			return null;
		}

	}

	@Override
	public List<ConsumersMasterBean> getemployeeConsumers(String region) {
	     EntityManager manager=factory.createEntityManager();
		 String jpql=" from ConsumersMasterBean where region = :regionc";
		  Query query=manager.createQuery(jpql);
		  query.setParameter("regionc", region);
		  List<ConsumersMasterBean> list=query.getResultList();
		  if (list != null) {
			  return list;
		}else {
			return null;
		}
		 
	 
	
	}

	

	@Override
	public EmployeeMaster getEmployeedetails(int empId) {
		EntityManager manager=factory.createEntityManager();
		EmployeeMaster employeeMasters=manager.find(EmployeeMaster.class, empId);
		return employeeMasters;
	}//End of getEmployeeDetails

}
