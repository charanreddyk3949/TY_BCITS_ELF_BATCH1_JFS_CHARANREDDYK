package com.bcits.employeedatajpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bcits.employeedatajpa.beans.EmployeeInfoBean;

public interface EmployeeRepository extends CrudRepository<EmployeeInfoBean, Integer> {
	
	
	@Query("from EmployeeInfoBean where empId= :id and password= :pwd")
	public EmployeeInfoBean getEmployeeByIdAndPassword(@Param("id") int empId,@Param("pwd") String password) ;
		
		
	

}//End of repository
