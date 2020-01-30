package com.bcits.springboot.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.springboot.beans.EmployeeInfoBean;


@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	@PersistenceUnit // (or)@Autowired
	private EntityManagerFactory factory;
	
//	@PersistenceContext
//	private  EntityManager manager;
	
	
//	private EntityManagerFactory factory1=Persistence.createEntityManagerFactory("emsPersitenceUnit");

	@Override
	public boolean addEmployee(
			EmployeeInfoBean employeeInfoBean) {
    	EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		boolean isAdded = false;
		try {
			
			transaction.begin();
			manager.persist(employeeInfoBean);
			transaction.commit();	
			isAdded=true;
			return isAdded;
		} catch (Exception e) {
			
			e.printStackTrace();
			return isAdded;
		}	
	}

	@Override
	public boolean deleteEmployee(Integer empId) {
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
			transaction.rollback();
			e.printStackTrace();
		   }
		return isDeleted;
//		manager.close();
	}
	

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
          EntityManager manager=factory.createEntityManager();
          EntityTransaction transaction=manager.getTransaction();
          Integer empId=employeeInfoBean.getEmpId();
          String name= employeeInfoBean.getName();
          Long mobileNo=employeeInfoBean.getMobileNo();
          String officialMailid=employeeInfoBean.getOfficialMailid();
          Date dateOfBirth=employeeInfoBean.getDateOfBirth();
          Date dateOfJoining=employeeInfoBean.getDateOfJoining();
          String designation=employeeInfoBean.getDesignation();
          String bloodGroup=employeeInfoBean.getBloodGroup();
          Double salary=employeeInfoBean.getSalary();
          Integer deptId=employeeInfoBean.getDeptId();
          Integer managerId=employeeInfoBean.getManagerId();
          String password=employeeInfoBean.getPassword();
          EmployeeInfoBean employeeInfoBean2=manager.find(EmployeeInfoBean.class, empId);
          boolean isUpdate=false;
          try {
        	  transaction.begin();
        	  employeeInfoBean2.setName(name);
        	  employeeInfoBean2.setMobileNo(mobileNo);
        	  employeeInfoBean2.setOfficialMailid(officialMailid);
        	  employeeInfoBean2.setDateOfBirth(dateOfBirth);
        	  employeeInfoBean2.setDateOfJoining(dateOfJoining);
        	  employeeInfoBean2.setDesignation(designation);
        	  employeeInfoBean2.setBloodGroup(bloodGroup);
        	  employeeInfoBean2.setSalary(salary);
        	  employeeInfoBean2.setDeptId(deptId);
        	  employeeInfoBean2.setManagerId(managerId);
        	  employeeInfoBean2.setPassword(password);
        	  transaction.commit();
        	  
        	  isUpdate=true;
        	  
        	  return isUpdate;
        	  
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
         
		return isUpdate;
//		manager.close();
	}

	@Override
	public EmployeeInfoBean getEmployee(Integer empId) {
		EntityManager manager=factory.createEntityManager();
		EmployeeInfoBean employeeInfoBean=manager.find(EmployeeInfoBean.class, empId);
		 return employeeInfoBean;
//			manager.close();	 
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployee() {
		EntityManager manager=factory.createEntityManager();
		String jpql = " from EmployeeInfoBean";
		Query query = manager.createQuery(jpql);
		List<EmployeeInfoBean> list = query.getResultList();
		
		return list;
//		manager.close();
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
//	manager.close();
	}//End of authenticate

}//End Of class
