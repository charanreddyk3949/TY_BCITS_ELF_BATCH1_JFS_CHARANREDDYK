package com.bcits.discomusecase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
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

}//End of service
