package com.bcits.springsecurityrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.springsecurityrest.beans.EmpInfoBean;

@Repository
public class EmpDAOImpl  implements EmpDAO{
     
	@PersistenceUnit
	private EntityManagerFactory factory;
	
	
	@Override
	public boolean register(EmpInfoBean empInfoBean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction tx=manager.getTransaction();
		
		boolean isRegistered=false;
		try {
			tx.begin();
			manager.persist(empInfoBean);
			tx.commit();
			
			isRegistered=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			manager.close();
		}
		
		return isRegistered;
	}//End of getRegistered()

	@Override
	public EmpInfoBean getEmplioyee(int empId) {
		EntityManager manager=factory.createEntityManager();
		EmpInfoBean empInfoBean=manager.find(EmpInfoBean.class, empId);
		manager.close();
		
		return empInfoBean;
	}//End of getEmployee()

	@Override
	public List<EmpInfoBean> getAllEmployees() {
		EntityManager manager=factory.createEntityManager();
		String jpql="from EmpInfoBean";
		Query query=manager.createQuery(jpql);		
		List<EmpInfoBean> employeesList= query.getResultList(); 
		manager.close();
		
		return employeesList;
	}//End of getAllEMployees()

}//End of Class
