package com.bcits.discomusecase.consumerdao;

import java.util.Date;


import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.BillHistoryPK;
import com.bcits.discomusecase.beans.ConsumerSupportRequest;
import com.bcits.discomusecase.beans.ConsumerSupportRequestPK;
import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.beans.MonthlyConsumption;
import com.bcits.discomusecase.beans.MonthlyConsumptionPK;
import com.bcits.discomusecase.beans.PaymentDetails;
import com.bcits.discomusecase.beans.TariffBillGenerator;
import com.bcits.discomusecase.mail.EmailGenerator;


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
		 String jpql=" from ConsumersMasterBean where region = :consumerRegion";
		  Query query=manager.createQuery(jpql);
		  query.setParameter("consumerRegion", region);
		  List<ConsumersMasterBean> list=query.getResultList();
		  if (list != null) {
			  return list;
		}else {
			return null;
		}
	
	}
	
    @Override
	public EmployeeMaster getEmployeedetails(Integer empId) {
		EntityManager manager=factory.createEntityManager();
		EmployeeMaster employeeMasters=manager.find(EmployeeMaster.class, empId);
		return employeeMasters;
	}//End of getEmployeeDetails

	@Override
	public ConsumersMasterBean getConsumer(String rrNumber) {
		   EntityManager manager =factory.createEntityManager();
		   ConsumersMasterBean   consumersMasterBean=manager.find(ConsumersMasterBean.class, rrNumber);
		if(consumersMasterBean != null) {
			return consumersMasterBean;
		}
		return null;
	}

	@Override
	public Double getFinalReading(String rrNumber) {
		 EntityManager manager=factory.createEntityManager();
		CurrentBill currentBill= manager.find(CurrentBill.class, rrNumber);
		String jpql=" select presentReading from CurrentBill where rrNumber= :rrNum ORDER BY presentReading DESC";
		Query query=manager.createQuery(jpql);
		query.setParameter("rrNum", rrNumber);
		query.getMaxResults();
		Double double1=(Double)query.getSingleResult();
		if (double1 != null) {
			return double1;
		}
		return null;
	}//End of getFinalReading()

/**	@Override
	public boolean getBillGenerator(Date dueDate,CurrentBill currentBill) {
        EntityManager manager=factory.createEntityManager();
        EntityTransaction transaction=manager.getTransaction();
        CurrentBill  bill= manager.find(CurrentBill.class, currentBill.getRrNumber());
        ConsumersMasterBean consumersMasterBean=manager.find(ConsumersMasterBean.class, currentBill.getRrNumber());
        Double initialReading=0.0;
        Double billAmount=0.0;
       
       if (consumersMasterBean != null) {
    	  if(bill != null) {
    	   initialReading=bill.getPresentReading();
  
    	   BillHistoryPK billHistoryPK=new BillHistoryPK();
    	   billHistoryPK.setRrNumber(bill.getRrNumber());
    	   billHistoryPK.setDate(new Date());
    	   
    	   BillHistory billHistory =new BillHistory();
    	   billHistory.setBillAmount(bill.getBillAmount());
    	   billHistory.setRegion(consumersMasterBean.getRegion());
    	   billHistory.setUnitsConsumed(bill.getConsumption());
    	   billHistory.setBillHistoryPK(billHistoryPK);
    	   
    	   transaction.begin();
    	   manager.persist(billHistory);
    	   transaction.commit();
    	  
    	   try {
   	       Double unitsConsumed=currentBill.getPresentReading()-initialReading;
   	    TariffBillGenerator billGenerator=new TariffBillGenerator();
           billAmount=billGenerator.getBill(unitsConsumed, consumersMasterBean.getConsumerType());
    	   transaction.begin();
    	   bill.setBillAmount(billAmount);
    	   bill.setConsumption(unitsConsumed);
    	   bill.setDueDate(dueDate);
    	   bill.setInitialReading(initialReading);
    	   bill.setPresentReading(currentBill.getPresentReading());    
    	   transaction.commit();
           
    	   return true;
		   } catch (Exception e) {
			   e.printStackTrace();
			return false;
		   }
    	  
		 
	   }else {
		   Double unitsConsumed=currentBill.getPresentReading()-initialReading;
		   TariffBillGenerator generator=new TariffBillGenerator();
		   billAmount=generator.getBill(unitsConsumed, consumersMasterBean.getConsumerType());
	   
		   try {
			   Double presentReading=unitsConsumed+initialReading;
			   transaction.begin();
			   
			   currentBill.setRrNumber(consumersMasterBean.getRrNumber());
			   currentBill.setConsumption(unitsConsumed);
			   currentBill.setBillAmount(billAmount);
			   currentBill.setInitialReading(initialReading);
			
		  
			manager.persist(currentBill);
			transaction.commit();
			manager.close();
			return true; 
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		
		}
		   
    }//End of else
       }
	return false;        
	}//End of getBillGenerator()
**/
	
	@Override
	public boolean getBillGenerator(Date dueDate, CurrentBill currentBill) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		CurrentBill bill = manager.find(CurrentBill.class, currentBill.getRrNumber());
		ConsumersMasterBean consumersMasterBean = manager.find(ConsumersMasterBean.class, currentBill.getRrNumber());
		Double initialReading = 0.0;
		Double billAmount = 0.0;
	
		if (consumersMasterBean != null) {
			if (bill != null) {
				
				initialReading = bill.getPresentReading();
				
			try {
					Double unitsConsumed = currentBill.getPresentReading() - initialReading;
					TariffBillGenerator billGenerator = new TariffBillGenerator();
				    billAmount = billGenerator.getBill(unitsConsumed, consumersMasterBean.getConsumerType());
                  
					transaction.begin();
					bill.setBillAmount(billAmount);
					bill.setConsumption(unitsConsumed);
					bill.setDueDate(dueDate);
					bill.setInitialReading(initialReading);
					bill.setPresentReading(currentBill.getPresentReading());
					transaction.commit();
				

				BillHistoryPK billHistoryPK = new BillHistoryPK();
				billHistoryPK.setRrNumber(bill.getRrNumber());
				billHistoryPK.setDate(new Date());

				BillHistory billHistory = new BillHistory();
				billHistory.setBillAmount(billAmount);
				billHistory.setRegion(consumersMasterBean.getRegion());
				billHistory.setUnitsConsumed(unitsConsumed);
				billHistory.setStatus("NotPaid");
				billHistory.setBillHistoryPK(billHistoryPK);

				transaction.begin();
				manager.persist(billHistory);
				transaction.commit();

				transaction.begin();
				MonthlyConsumption monthlyConsumption = new MonthlyConsumption();
				MonthlyConsumptionPK monthlyConsumptionPK = new MonthlyConsumptionPK();
				monthlyConsumptionPK.setRrNumber(consumersMasterBean.getRrNumber());
				monthlyConsumptionPK.setInitialDate(new Date());
				monthlyConsumption.setFinalDate(dueDate);
				monthlyConsumption.setInitialReading(initialReading);
				monthlyConsumption.setFinalReading(currentBill.getPresentReading());
				monthlyConsumption.setConsumptionUnits(unitsConsumed);
				monthlyConsumption.setMonthlyConsumptionPK(monthlyConsumptionPK);
				manager.persist(monthlyConsumption);
				transaction.commit();

				

					return true;
				} catch (Exception e) {
					e.printStackTrace();
					
				}

			} else {
				Double unitsConsumed = currentBill.getPresentReading() - initialReading;
				TariffBillGenerator generator = new TariffBillGenerator();
				billAmount = generator.getBill(unitsConsumed, consumersMasterBean.getConsumerType());
				
				try {
					Double presentReading = unitsConsumed + initialReading;
					transaction.begin();

					currentBill.setRrNumber(consumersMasterBean.getRrNumber());
					currentBill.setConsumption(unitsConsumed);
					currentBill.setBillAmount(billAmount);
					currentBill.setInitialReading(initialReading);

					manager.persist(currentBill);
					transaction.commit();

					transaction.begin();
					MonthlyConsumption monthlyConsumption = new MonthlyConsumption();
					MonthlyConsumptionPK monthlyConsumptionPK = new MonthlyConsumptionPK();
					monthlyConsumptionPK.setRrNumber(consumersMasterBean.getRrNumber());
					monthlyConsumptionPK.setInitialDate(new Date());
					monthlyConsumption.setFinalDate(dueDate);
					monthlyConsumption.setInitialReading(initialReading);
					monthlyConsumption.setFinalReading(presentReading);
					monthlyConsumption.setConsumptionUnits(unitsConsumed);
					monthlyConsumption.setMonthlyConsumptionPK(monthlyConsumptionPK);
					manager.persist(monthlyConsumption);
					transaction.commit();

					BillHistoryPK billHistoryPK = new BillHistoryPK();
					billHistoryPK.setRrNumber(consumersMasterBean.getRrNumber());
					billHistoryPK.setDate(new Date());

					BillHistory billHistory = new BillHistory();
					billHistory.setBillAmount(currentBill.getBillAmount());
					billHistory.setRegion(consumersMasterBean.getRegion());
					billHistory.setUnitsConsumed(currentBill.getConsumption());
					billHistory.setStatus("NotPaid");
					billHistory.setBillHistoryPK(billHistoryPK);
					transaction.begin();
					manager.persist(billHistory);
					transaction.commit();

					manager.close();
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				}

			} // End of else
		}
		return false;
	}// End of getBillGenerator()


	
	
	
	
	@Override
	public List<ConsumerSupportRequest> getAllRequests(String region) {
		EntityManager manager=factory.createEntityManager();
		
		String jpql="from ConsumerSupportRequest where region= :regionVal";
		Query query=manager.createQuery(jpql);
		query.setParameter("regionVal",region);
		List<ConsumerSupportRequest> requestList=query.getResultList();
		
			return requestList;
		
		
	}
	
	@Override
	public List<BillHistory> getBillHistory(String status) {
		
		EntityManager manager=factory.createEntityManager();
		String jpql="from BillHistory where status= :statusVal ";
		Query query=manager.createQuery(jpql);
		query.setParameter("statusVal", status);
		List<BillHistory> billList=query.getResultList();
				
		return billList;
	}

	@Override
	public boolean sendMail(String rrNumber) {
		EmailGenerator mail=new EmailGenerator();
		EntityManager manager=factory.createEntityManager();
		CurrentBill  bill=manager.find(CurrentBill.class, rrNumber);
		if (mail.sendMail(bill)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateResopnse(String rrNumber, Date date, String response) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String jpql = " from ConsumerSupportRequest where consumerSupportRequestPK.rrNumber= :rrNum and consumerSupportRequestPK.date= :dateVal ";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("rrNum", rrNumber);
		query.setParameter("dateVal", date);
		
		ConsumerSupportRequest consumerSupportRequest = (ConsumerSupportRequest) query.getSingleResult();

		if (consumerSupportRequest != null) {
			transaction.begin();
			consumerSupportRequest.setResponse(response);
			transaction.commit();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public ConsumerSupportRequest getRequestRecord(String rrNumber, Date date) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		String jpql="from ConsumerSupportRequest c where c.consumerSupportRequestPK.rrNumber= :rrNum and c.consumerSupportRequestPK.Date= :dateVal";
		Query  query=manager.createQuery(jpql);
		query.setParameter("rrNum", rrNumber);
		query.setParameter("dateVal", date);
		ConsumerSupportRequest consumerSupportRequest=(ConsumerSupportRequest) query.getSingleResult();
		return consumerSupportRequest;
	}

	

}//End of getConsumer()
