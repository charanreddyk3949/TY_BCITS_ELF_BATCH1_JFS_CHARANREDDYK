package com.bcits.discomusecase.service;

import java.util.Date;
import java.util.List;

import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.ConsumerSupportRequest;
import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.EmployeeMaster;

public interface EmployeeService {
	
	
	public EmployeeMaster authenticate(Integer empId,String password);
	
	public EmployeeMaster getEmployeedetails(Integer empId);

	public List<ConsumersMasterBean> getemployeeConsumers(String region);
	
	public ConsumersMasterBean getConsumer(String rrNumber);
	public Double getFinalReading(String rrNumber);
	
    public boolean getBillGenerator(Date dueDate,CurrentBill currentBill);

    public List<ConsumerSupportRequest> getAllRequests(String region);
    public List<BillHistory> getBillHistory(String status);
    
    public boolean sendMail(String rrNumber);


}
