package com.bcits.discomusecase.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.ConsumerSupportRequest;
import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.MonthlyConsumption;
import com.bcits.discomusecase.beans.PaymentDetails;
import com.bcits.discomusecase.consumerdao.ConsumerDAO;
import com.bcits.discomusecase.customeexceptions.ConsumerException;

@Service
public class ConsumerServiceImpl implements ConsumerService{
	
	@Autowired
	private ConsumerDAO dao;

	@Override
	public ConsumersMasterBean authenticate(String rrNumber, String password) {
		if (dao.authenticate(rrNumber, password) == null) {
			
			throw new ConsumerException("Please Provide Valid Credentials...");
		}else {
			return dao.authenticate(rrNumber, password);
		}
		
	}//End of authenticate()

	@Override
	public boolean addConsumer(ConsumersMasterBean consumersMasterBean) {
		
		return dao.addConsumer(consumersMasterBean);
	}//End of addConsumer()
	

	@Override
	public boolean deleteConsumer(Integer rrNumber) {
		if (rrNumber < 1) {
			return false;
		}
		return dao.deleteConsumer(rrNumber);
	}//End of deleteConsumer()

	
	@Override
	public boolean updateConsumer(ConsumersMasterBean consumersMasterBean) {
		
		return dao.updateConsumer(consumersMasterBean);
	}//End of updateConsumer()

	
	@Override
	public ConsumersMasterBean getConsumer(String rrNumber) {
		
		return dao.getConsumer(rrNumber);
	}//End of getConsumer()
	

	@Override
	public List<ConsumersMasterBean> getAllConsumers() {
		
		return dao.getAllConsumers();
		
	}//End of getAllConsumers()

	@Override
	public CurrentBill getBill(String rrNumber) {
		if (dao.getBill(rrNumber) == null) {
			throw new ConsumerException("New User No Current Bill is Found.");

		}else {
			return dao.getBill(rrNumber);
		}
		
	}

	@Override
	public List<BillHistory> getBillHistory() {
		
		return dao.getBillHistory();
		
	}//End of getBillHistory()

	@Override
	public PaymentDetails getPaymentDetails(String rrNumber) {
		
		return dao.getPaymentDetails(rrNumber);
		
	}//End of getPaymentDetails()

	@Override
	public List<MonthlyConsumption> getMonthlyConsuption() {
		
		return dao.getMonthlyConsuption();
		
	}//End of getMonthlyConsuption()

	@Override
	public boolean billPaymentPage(String rrNumber, Date date, Double amtPaid) {
		
		return dao.billPaymentPage(rrNumber, date, amtPaid);
	}

	@Override
	public boolean addComments(ConsumerSupportRequest consumerSupportRequest) {
		
		return dao.addComments(consumerSupportRequest);
	}

	
	

}//End of service
