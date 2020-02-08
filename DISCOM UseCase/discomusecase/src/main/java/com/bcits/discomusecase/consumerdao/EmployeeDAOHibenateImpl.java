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
import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.beans.MonthlyConsumption;
import com.bcits.discomusecase.beans.MonthlyConsumptionPK;
import com.bcits.discomusecase.beans.TariffBillGenerator;


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
    	   billHistory.setStatus("NotPaid");
    	   billHistory.setBillHistoryPK(billHistoryPK);
    	   
    	   transaction.begin();
    	   manager.persist(billHistory);
    	   transaction.commit();
    	   
    	   
    	   transaction.begin();
			MonthlyConsumption monthlyConsumption=new MonthlyConsumption();
			MonthlyConsumptionPK monthlyConsumptionPK= new MonthlyConsumptionPK();
			monthlyConsumptionPK.setRrNumber(consumersMasterBean.getRrNumber());
			monthlyConsumptionPK.setInitialDate(new Date());
			monthlyConsumption.setFinalDate(dueDate);
			monthlyConsumption.setInitialReading(bill.getInitialReading());
			monthlyConsumption.setFinalReading(initialReading);
			monthlyConsumption.setConsumptionUnits(bill.getConsumption());
			monthlyConsumption.setMonthlyConsumptionPK(monthlyConsumptionPK);
			manager.persist(monthlyConsumption);
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
			
			transaction.begin();
			MonthlyConsumption monthlyConsumption=new MonthlyConsumption();
			MonthlyConsumptionPK monthlyConsumptionPK= new MonthlyConsumptionPK();
			monthlyConsumptionPK.setRrNumber(consumersMasterBean.getRrNumber());
			monthlyConsumptionPK.setInitialDate(new Date());
			monthlyConsumption.setFinalDate(dueDate);
			monthlyConsumption.setInitialReading(initialReading);
			monthlyConsumption.setFinalReading(presentReading);
			monthlyConsumption.setConsumptionUnits(unitsConsumed);
			monthlyConsumption.setMonthlyConsumptionPK(monthlyConsumptionPK);
			manager.persist(monthlyConsumption);
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

}//End of getConsumer()
