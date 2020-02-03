package com.bcits.discomusecase.service;

import java.util.List;


import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.MonthlyConsumption;
import com.bcits.discomusecase.beans.PaymentDetails;

public interface ConsumerService {
	
public ConsumersMasterBean authenticate(String rrNumber, String password);
	
	public boolean addConsumer(ConsumersMasterBean consumersMasterBean);
	public boolean deleteConsumer(Integer rrNumber);
	public boolean updateConsumer(ConsumersMasterBean consumersMasterBean);
	public ConsumersMasterBean getConsumer(String rrNumber);
	public List<ConsumersMasterBean> getAllConsumers();
    
    public CurrentBill getBill(String rrNumber);
	public List<BillHistory> getBillHistory();
	
	 public PaymentDetails  getPaymentDetails(String rrNumber);
	 public List<MonthlyConsumption> getMonthlyConsuption();
}//End of ConsumerService
