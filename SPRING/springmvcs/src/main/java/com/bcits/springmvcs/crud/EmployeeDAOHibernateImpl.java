package com.bcits.springmvcs.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.springmvcs.bean.EmployeeInfoBean;
import com.bcits.springmvcs.employeedao.EmployeeDAO;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	@PersistenceUnit // (or)@Autowired
	private EntityManagerFactory factory;
	
//	private EntityManagerFactory factory1=Persistence.createEntityManagerFactory("emsPersitenceUnit");

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		boolean isAdded = false;
		try {
			
			transaction.begin();
			manager.persist(employeeInfoBean);
			transaction.commit();
			
			isAdded=true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return isAdded;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		EmployeeInfoBean employeeInfoBean=manager.find(EmployeeInfoBean.class, empId);
		boolean isDeleted = false;
		
		  try {
			transaction.begin();
			manager.remove(employeeInfoBean);
			transaction.commit();
			isDeleted=true;
		   } catch (Exception e) {
			
			e.printStackTrace();
		   }
		return isDeleted;
	}
	

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
          EntityManager manager=factory.createEntityManager();
          
		
         
		return false;
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		EntityManager manager=factory.createEntityManager();
		EmployeeInfoBean employeeInfoBean=manager.find(EmployeeInfoBean.class, empId);
		 return employeeInfoBean;
		 
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployee() {
		EntityManager manager=factory.createEntityManager();
		String jpql = " from EmployeePrimaryInfo";
		Query query = manager.createQuery(jpql);
		List<EmployeeInfoBean> list = query.getResultList();
		
		return list;
	}

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		EntityManager manager=factory.createEntityManager();
		EmployeeInfoBean employeeInfoBean=manager.find(EmployeeInfoBean.class, empId);
		
		if(employeeInfoBean != null && employeeInfoBean.getPassword().equals(password)) {
			return employeeInfoBean;
		}else {
			return null;
		}
	
	}//End of authenticate

}//End Of class
