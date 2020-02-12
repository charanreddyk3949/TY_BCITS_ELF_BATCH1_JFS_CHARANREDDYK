package com.bcits.discomusecase.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.ConsumerSupportRequest;
import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.consumerdao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public EmployeeMaster authenticate(Integer empId, String password) {
		
		return dao.authenticate(empId, password);
	}

	@Override
	public List<ConsumersMasterBean> getemployeeConsumers(String region) {
		
		return  dao.getemployeeConsumers(region);
		
	}

	@Override
	public EmployeeMaster getEmployeedetails(Integer empId) {
		
		return dao.getEmployeedetails(empId);
	}

	@Override
	public ConsumersMasterBean getConsumer(String rrNumber) {
		
		return dao.getConsumer(rrNumber);
	}

	@Override
	public Double getFinalReading(String rrNumber) {
		
		return dao.getFinalReading(rrNumber);
	}

	@Override
	public boolean getBillGenerator(Date dueDate, CurrentBill currentBill) {
		
		return dao.getBillGenerator(dueDate, currentBill);
	}

	@Override
	public List<ConsumerSupportRequest> getAllRequests(String region) {
		
		return dao.getAllRequests(region);
	}

	@Override
	public List<BillHistory> getBillHistory(String status) {
		
		return dao.getBillHistory(status);
	}

	@Override
	public boolean sendMail(String rrNumber) {
		
		return dao.sendMail(rrNumber);
	}

	@Override
	public boolean updateResopnse(String rrNumber, Date date, String response) {
		
		return dao.updateResopnse(rrNumber, date, response);
	}

	@Override
	public ConsumerSupportRequest getRequestRecord(String rrNumber, Date date) {
		
		return dao.getRequestRecord(rrNumber, date);
	}

}//End of Service
