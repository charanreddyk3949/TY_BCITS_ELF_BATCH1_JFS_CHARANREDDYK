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
		
	 return dao.authenticate(rrNumber, password);
		
		
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
	public boolean updateConsumer(String rrNumber,ConsumersMasterBean consumersMasterBean) {
		
		return dao.updateConsumer(rrNumber,consumersMasterBean);
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

			return dao.getBill(rrNumber);

		
	}

	@Override
	public List<BillHistory> getBillHistory(String rrNumber) {
		
		return dao.getBillHistory(rrNumber);
		
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
    public boolean addComments(String rrNumber,String region,ConsumerSupportRequest consumerSupportRequest) {
		
		return dao.addComments(rrNumber, region, consumerSupportRequest);
	}

	@Override
	public List<ConsumerSupportRequest> displayResponse(String rrNumber) {
		
		return dao.displayResponse(rrNumber);
	}

	

	
	

}//End of service
