package com.bcits.discomusecase.service;

import java.util.List;

import com.bcits.discomusecase.beans.ConsumersMasterBean;

public interface ConsumerService {
	
public ConsumersMasterBean authenticate(String rrNumber, String password);
	
	public boolean addConsumer(ConsumersMasterBean consumersMasterBean);
	public boolean deleteConsumer(Integer rrNumber);
	public boolean updateConsumer(ConsumersMasterBean consumersMasterBean);
	public ConsumersMasterBean getConsumer(String rrNumber);
	public List<ConsumersMasterBean> getAllConsumers();

}//End of ConsumerService
