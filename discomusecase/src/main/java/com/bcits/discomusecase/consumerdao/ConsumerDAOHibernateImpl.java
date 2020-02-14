package com.bcits.discomusecase.consumerdao;

import java.util.Date;
import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.BillHistoryPK;
import com.bcits.discomusecase.beans.ConsumerSupportRequest;
import com.bcits.discomusecase.beans.ConsumerSupportRequestPK;
import com.bcits.discomusecase.beans.ConsumersMasterBean;

import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.MonthlyConsumption;
import com.bcits.discomusecase.beans.PaymentDetails;
import com.bcits.discomusecase.customeexceptions.ConsumerException;
import com.bcits.discomusecase.mail.EmailGenerator;

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
		
		if (consumersMasterBean.getPassword().equals(consumersMasterBean.getConfirmPassword())) {
			try {	
				transaction.begin();
				manager.persist(consumersMasterBean);
				transaction.commit();	
				isAdded=true;
				return isAdded;
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
		}else {
		    throw new ConsumerException("Password and Confirm Password Should Match.");
		}	
		return isAdded;
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
	public boolean updateConsumer(String rrNumber,ConsumersMasterBean consumersMasterBean) {
		EntityManager manager=factory.createEntityManager();
        EntityTransaction transaction=manager.getTransaction();            
        String firstName= consumersMasterBean.getFirstName();     
        String email=consumersMasterBean.getEmail();
        String address1=consumersMasterBean.getAddress1();      
        String password=consumersMasterBean.getPassword();
        Long mobileNumber=consumersMasterBean.getMobileNumber();
        ConsumersMasterBean consumersMasterBean2=manager.find(ConsumersMasterBean.class, rrNumber);
        boolean isUpdate=false;
        try {
      	  transaction.begin();
      	  
      	  if (firstName != null && !firstName.isEmpty()) {
      		consumersMasterBean2.setFirstName(firstName);    		
		   }
      	 
      	if (email != null && !email.isEmpty()) {
		 	consumersMasterBean2.setEmail(email);
		}
      	if (address1 != null && !address1.isEmpty()) {
		 	consumersMasterBean2.setAddress1(address1);
		}
      	if (mobileNumber != null ) {
		 	consumersMasterBean2.setMobileNumber(mobileNumber);
		}
      	
      	if (password != null && !password.isEmpty()) {
		 	consumersMasterBean2.setPassword(password);
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

	@Override
	public CurrentBill getBill(String rrNumber) {
		EntityManager manager=factory.createEntityManager();
		CurrentBill currentBill=manager.find(CurrentBill.class, rrNumber);

		if (currentBill != null) {
			 return currentBill;
		}
		else {
			CurrentBill  currentBill3=new CurrentBill();
			currentBill3.setRrNumber(rrNumber);
			currentBill3.setPresentReading(0.0);
			
			 return currentBill3;
			
		}
			
	}

	@Override
	public  List<BillHistory> getBillHistory(String rrNumber) {
		 EntityManager manager=factory.createEntityManager();
		 String jpql=" from BillHistory b where b.billHistoryPK.rrNumber= :rrNum";
		 Query query=manager.createQuery(jpql);
		 query.setParameter("rrNum", rrNumber);
		 List<BillHistory> billHistory=query.getResultList();
		 
		return billHistory;
	}

	@Override
	public PaymentDetails getPaymentDetails(String rrNumber) {
		EntityManager manager=factory.createEntityManager();
		PaymentDetails paymentDetails=manager.find(PaymentDetails.class, rrNumber);
		
		return paymentDetails;
	}

	@Override
	public List<MonthlyConsumption> getMonthlyConsuption() {
		EntityManager manager =factory.createEntityManager();
		String jpql=" from MonthlyConsumption";
		 Query query=manager.createQuery(jpql);
		List<MonthlyConsumption> consumptionList=query.getResultList();
		
		return consumptionList;
	}//End of getMonthlyConsuption()

//	@Override
//	public boolean billPaymentPage(String rrNumber, Date date, Double amtPaid) {
//		
//		EntityManager manager =factory.createEntityManager();
//		EntityTransaction transaction=manager.getTransaction();
//	  
//	    CurrentBill currentBill= manager.find(CurrentBill.class, rrNumber);
//	    PaymentDetails details=manager.find(PaymentDetails.class, rrNumber);
//	  
//	    
////	    String jpql="from BillHistory b where b.billHistoryPK.rrNumber= :rrNum and b.status= :statusVal";
////	    Query query=manager.createQuery(jpql);
////	    query.setParameter("rrNum", rrNumber);
////	    query.setParameter("statusVal", "NotPaid");
////	    BillHistory billHistory2= (BillHistory) query.getSingleResult();
//	  
//	    ConsumersMasterBean consumersMasterBean=manager.find(ConsumersMasterBean.class, rrNumber);
//	    
//	    boolean isAdded=false;	
////	   if (currentBill != null) {
////		   transaction.begin();
////		   billHistory2.setStatus("Paid");
////		   transaction.commit();
//	
//	    
//	   if(details == null) {
//		PaymentDetails paymentDetails=  new PaymentDetails();
//	    paymentDetails.setRrNumber(rrNumber);
//	    paymentDetails.setTxnNumber(8756487);
//	    paymentDetails.setTxnDate(date);
//	    paymentDetails.setTxnType("Online payment");
//	    paymentDetails.setTxnAmount(amtPaid);
//	    paymentDetails.setAmtPaid(amtPaid);
//	    paymentDetails.setTxnStatus("Success");
//    
//	     
//	    try {
//	    	transaction.begin();
//	    	manager.persist(paymentDetails);
//	       
//	    	transaction.commit();
//	    	isAdded= true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			transaction.rollback();
//		}	
//	  }
//	  }else {
//		  try {
//			  transaction.begin();
////			  BillHistory billHistory=new BillHistory();
////			  BillHistoryPK billHistoryPK=new BillHistoryPK();
////			  billHistoryPK.setRrNumber(rrNumber);
////			  billHistoryPK.setDate(date);
////			  billHistory.setBillAmount(amtPaid);
////			  billHistory.setRegion(consumersMasterBean.getRegion());
////			  billHistory.setUnitsConsumed(currentBill.getConsumption());
////			  billHistory.setBillHistoryPK(billHistoryPK);
//			  billHistory2.setStatus("Paid");
//			  transaction.commit();
//			  
////			  manager.persist(billHistory2);
//  
//			  details.setTxnNumber(9756487);
//			  details.setTxnDate(date);
//			  details.setTxnType("Online payment");
//			  details.setTxnAmount(amtPaid);
//			  details.setAmtPaid(amtPaid);
//			  details.setTxnStatus("Success");
//			  transaction.commit();
//		      isAdded= true;
//			
//		} catch (Exception e) {
//			transaction.rollback();
//			e.printStackTrace();
//		}
//		    
//	   isAdded=true;
//	}
//		return isAdded;
//	}//End of 
	
	@Override
	public boolean billPaymentPage(String rrNumber, Date date, Double amtPaid) {
		CurrentBill bill = new CurrentBill();
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		PaymentDetails paymentDetails = new PaymentDetails();
		CurrentBill currentBill = manager.find(CurrentBill.class, rrNumber);
		PaymentDetails details = manager.find(PaymentDetails.class, rrNumber);
		ConsumersMasterBean consumersMasterBean = manager.find(ConsumersMasterBean.class, rrNumber);

		
//        String jpql1="from PaymentDetails where rrNumber= :rrNum and amtPaid= :amtVal";	
//        Query query1 = manager.createQuery(jpql1);
//        query1.setParameter("rrNum", rrNumber);
//        query1.setParameter("amtVal", amtPaid);
//        PaymentDetails details1=(PaymentDetails) query1.getSingleResult();
        
		String jpql = "from BillHistory b where b.billHistoryPK.rrNumber= :rrNum and b.status= :statusVal ";
		Query query = manager.createQuery(jpql);
		query.setMaxResults(1);
		query.setParameter("rrNum", rrNumber);
		query.setParameter("statusVal", "NotPaid");
		
		BillHistory billHistory2 = (BillHistory) query.getSingleResult();
			
		boolean isAdded = false;		
		if (details == null) {
//			if (details1 == null) {
				
			
			paymentDetails.setRrNumber(rrNumber);
			paymentDetails.setTxnNumber(8756487);
			paymentDetails.setTxnDate(date);
			paymentDetails.setTxnType("Online payment");
			paymentDetails.setTxnAmount(amtPaid);
			paymentDetails.setAmtPaid(amtPaid);
			paymentDetails.setTxnStatus("Success");

			transaction.begin();
			manager.remove(billHistory2);
			transaction.commit();

			transaction.begin();
			BillHistory billHistory = new BillHistory();
			BillHistoryPK billHistoryPK = new BillHistoryPK();
			billHistoryPK.setRrNumber(rrNumber);
			billHistoryPK.setDate(date);
			billHistory.setBillAmount(amtPaid);
			billHistory.setRegion(consumersMasterBean.getRegion());
			billHistory.setUnitsConsumed(currentBill.getConsumption());
			billHistory.setBillHistoryPK(billHistoryPK);
			billHistory.setStatus("Paid");

			manager.persist(billHistory);
			transaction.commit();
			try {
				transaction.begin();
				manager.persist(paymentDetails);

				transaction.commit();
				isAdded = true;
			} catch (Exception e) {
				e.printStackTrace();
				transaction.rollback();
			}
		} else {
			try {
				transaction.begin();
				manager.remove(billHistory2);
				transaction.commit();

				transaction.begin();
				BillHistory billHistory = new BillHistory();
				BillHistoryPK billHistoryPK = new BillHistoryPK();
				billHistoryPK.setRrNumber(rrNumber);
				billHistoryPK.setDate(date);
				billHistory.setBillAmount(amtPaid);
				billHistory.setRegion(consumersMasterBean.getRegion());
				billHistory.setUnitsConsumed(currentBill.getConsumption());
				billHistory.setBillHistoryPK(billHistoryPK);
				billHistory.setStatus("Paid");

				manager.persist(billHistory);

				details.setTxnNumber(9756487);
				details.setTxnDate(date);
				details.setTxnType("Online payment");
				details.setTxnAmount(amtPaid);
				details.setAmtPaid(amtPaid);
				details.setTxnStatus("Success");
				transaction.commit();
				isAdded = true;

			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}
			isAdded = true;
		}
//		}else {
//			isAdded=false;
//		}
		return isAdded;
	}
	@Override
	public boolean addComments(String rrNumber,String region,ConsumerSupportRequest consumerSupportRequest) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		boolean isAdded= false;
	   try {
		   transaction.begin();
		   ConsumerSupportRequestPK consumerSupportRequestPK=new ConsumerSupportRequestPK();
		   consumerSupportRequestPK.setRrNumber(rrNumber);
		   consumerSupportRequestPK.setDate(new Date());
		   consumerSupportRequest.setConsumerSupportRequestPK(consumerSupportRequestPK);
		   consumerSupportRequest.setRegion(region);
		   consumerSupportRequest.setResponse("Not Responded");
			manager.persist(consumerSupportRequest);
			transaction.commit();
		    isAdded=true;	    
		
	  } catch (Exception e) {
		e.printStackTrace();
		transaction.rollback();
	  }	
		return isAdded;
	}//End of addcomments()

	@Override
	public List<ConsumerSupportRequest> displayResponse(String rrNumber) {
		EntityManager manager=factory.createEntityManager();
		String jpql=" from ConsumerSupportRequest where consumerSupportRequestPK.rrNumber= :rrNum ";
		Query  query=manager.createQuery(jpql);
		query.setParameter("rrNum", rrNumber);
		List<ConsumerSupportRequest> consumerSupportRequest= query.getResultList();
	  if (consumerSupportRequest != null) {
		return consumerSupportRequest;
	   }
		return null;
	}//End of displayRequest()

	@Override
	public List<BillHistory> getPendingBills(String rrNumber, String status) {
		
		EntityManager manager=factory.createEntityManager();
		String jpql=" from BillHistory where billHistoryPK.rrNumber= :rrNum and status= :statusVal ";
		Query  query=manager.createQuery(jpql);
		query.setParameter("rrNum", rrNumber);
		query.setParameter("statusVal", "NotPaid");
		List<BillHistory> billList=query.getResultList();
		return billList;
	}//End of billList()

	

	

}//End of class
