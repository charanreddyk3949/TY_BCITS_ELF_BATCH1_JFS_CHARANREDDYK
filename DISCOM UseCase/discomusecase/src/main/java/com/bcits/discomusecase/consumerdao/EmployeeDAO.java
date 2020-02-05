package com.bcits.discomusecase.consumerdao;

import java.util.Date;
import java.util.List;

import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.EmployeeMaster;

public interface EmployeeDAO {
	
	
	public EmployeeMaster authenticate(Integer empId,String password);
	
	public EmployeeMaster getEmployeedetails(Integer empId);
	
	public List<ConsumersMasterBean> getemployeeConsumers(String region);
	
	public ConsumersMasterBean getConsumer(String rrNumber);
	
	public Double getFinalReading(String rrNumber);
	
    public boolean getBillGenerator(CurrentBill currentBill);
	
	

}
