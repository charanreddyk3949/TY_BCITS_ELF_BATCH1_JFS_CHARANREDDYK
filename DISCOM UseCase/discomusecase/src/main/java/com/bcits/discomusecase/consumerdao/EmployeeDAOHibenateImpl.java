package com.bcits.discomusecase.consumerdao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

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

}
