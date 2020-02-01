package com.bcits.discomusecase.consumerdao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.ConsumersMasterBean;

@Repository
public class ConsumerDAOHibernateImpl implements ConsumerDAO{
	
	@PersistenceUnit // (or)@Autowired
	private EntityManagerFactory factory;

	@Override
	public ConsumersMasterBean authenticate(String rrNumber, String password) {
		EntityManager manager=factory.createEntityManager();
		ConsumersMasterBean consumersMasterBean=manager.find(ConsumersMasterBean.class, rrNumber);
		
		if(consumersMasterBean != null && consumersMasterBean.getPassword().equals(password)) {
			return consumersMasterBean;
		}else {
			return null;
		}
	}//End of authenticate()

	@Override
	public boolean addConsumer(ConsumersMasterBean consumersMasterBean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		boolean isAdded = false;
		try {	
			transaction.begin();
			manager.persist(consumersMasterBean);
			transaction.commit();	
			isAdded=true;
			return isAdded;
		} catch (Exception e) {
			
			e.printStackTrace();
			return isAdded;
		}	
	}//End of addConsumer()
	

	@Override
	public boolean deleteConsumer(Integer rrNumber) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		ConsumersMasterBean consumersMasterBean=manager.find(ConsumersMasterBean.class, rrNumber);
		boolean isDeleted = false;
		
		  try {
			transaction.begin();
			manager.remove(consumersMasterBean);
			transaction.commit();
			isDeleted=true;
		   } catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		   }
		return isDeleted;
		
	}//End of deleteConsumer()

	@Override
	public boolean updateConsumer(ConsumersMasterBean consumersMasterBean) {
		EntityManager manager=factory.createEntityManager();
        EntityTransaction transaction=manager.getTransaction();
        
        String rrNumber=consumersMasterBean.getRrNumber();
        String firstName= consumersMasterBean.getFirstName();
        String lastName= consumersMasterBean.getLastName();
        String email=consumersMasterBean.getEmail();
        String address1=consumersMasterBean.getAddress1();
        String address2=consumersMasterBean.getAddress2();
        String city=consumersMasterBean.getCity();
        String state=consumersMasterBean.getState();
        long pinCode=consumersMasterBean.getPinCode();
        String region=consumersMasterBean.getRegion();
        String consumerType=consumersMasterBean.getConsumerType();
        String password=consumersMasterBean.getPassword();
        String confirmPassword=consumersMasterBean.getConfirmPassword();
        ConsumersMasterBean consumersMasterBean2=manager.find(ConsumersMasterBean.class, rrNumber);
        boolean isUpdate=false;
        try {
      	  transaction.begin();
      	  if (rrNumber != null && rrNumber.isEmpty()) {
      		consumersMasterBean2.setRrNumber(rrNumber);    		
		   }
      	  if (firstName != null && firstName.isEmpty()) {
      		consumersMasterBean2.setFirstName(firstName);    		
		   }
      	  if (lastName != null && lastName.isEmpty()) {
		 	consumersMasterBean2.setLastName(lastName);
		}
      	if (email != null && email.isEmpty()) {
		 	consumersMasterBean2.setEmail(email);
		}
      	if (address1 != null && address1.isEmpty()) {
		 	consumersMasterBean2.setAddress1(address1);
		}
      	if (address2 != null && address2.isEmpty()) {
		 	consumersMasterBean2.setAddress2(address2);
		}
      	if (city != null && city.isEmpty()) {
		 	consumersMasterBean2.setCity(city);
		}
      	if (state != null && state.isEmpty()) {
		 	consumersMasterBean2.setState(state);
		}
      	if (region != null && region.isEmpty()) {
		 	consumersMasterBean2.setRegion(region);
		}
      	if (consumerType != null && consumerType.isEmpty()) {
		 	consumersMasterBean2.setConsumerType(consumerType);
		}
      	if (password != null && password.isEmpty()) {
		 	consumersMasterBean2.setPassword(password);
		}
      	if (confirmPassword != null && confirmPassword.isEmpty()) {
		 	consumersMasterBean2.setConfirmPassword(confirmPassword);
		}
      	  
      	  transaction.commit();  
      	  isUpdate=true; 
      	  return isUpdate;
      	  
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
       
		return isUpdate;
		
	}//End of updateConsumer
	

	@Override
	public ConsumersMasterBean getConsumer(String rrNumber) {
		EntityManager manager=factory.createEntityManager();
		ConsumersMasterBean consumersMasterBean=manager.find(ConsumersMasterBean.class, rrNumber);
		 return consumersMasterBean;	 
	}

	@Override
	public List<ConsumersMasterBean> getAllConsumers() {
		EntityManager manager=factory.createEntityManager();
		String jpql = " from ConsumersMasterBean";
		Query query = manager.createQuery(jpql);
		List<ConsumersMasterBean> list = query.getResultList();
		
		return list;
	}//End of getAllConsumers()

}//End of class
