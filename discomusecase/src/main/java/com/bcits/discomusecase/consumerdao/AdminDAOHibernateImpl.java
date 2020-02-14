package com.bcits.discomusecase.consumerdao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.AdminBean;
import com.bcits.discomusecase.beans.EmployeeMaster;

@Repository
public class AdminDAOHibernateImpl implements AdminDAO{
	
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public AdminBean authenticate(int adminId, String Password) {
		EntityManager manager=factory.createEntityManager();
		AdminBean adminBean=manager.find(AdminBean.class, adminId);
		if (adminBean.getPassword().equals(Password)) {
			return adminBean;
		}else {
			return null;
		}
		
	}//End of Authenticate()

	@Override
	public boolean createEmployee(EmployeeMaster employeeMaster) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		boolean isCreated= false;
		try {
			transaction.begin();
			manager.persist(employeeMaster);
			transaction.commit();
			isCreated=true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return isCreated;
	}//End of createEmployee()

}//End of class
