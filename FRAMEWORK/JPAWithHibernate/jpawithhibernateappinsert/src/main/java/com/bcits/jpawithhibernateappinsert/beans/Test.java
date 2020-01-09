package com.bcits.jpawithhibernateappinsert.beans;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.*;
@Entity
@Table(name="employee_primary_info")
public class Test {
    @Id
	@Column
	private int empid;
	@Column
	private String name;
	@Column
	private long mobileno;
	@Column
	private String officialmailid;
	@Column
	private Date dateofbirth;
	@Column
	private Date dateofjoining;
	@Column
	private String designation;
	@Column
	private String bloodgroup;
	@Column
	private int salary;
	@Column
	private int deptid;
	@Column
	private int managersal;
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getOfficialmailid() {
		return officialmailid;
	}
	public void setOfficialmailid(String officialmailid) {
		this.officialmailid = officialmailid;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public Date getDateofjoining() {
		return dateofjoining;
	}
	public void setDateofjoining(Date dateofjoining) {
		this.dateofjoining = dateofjoining;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public int getManagersal() {
		return managersal;
	}
	public void setManagersal(int managersal) {
		this.managersal = managersal;
	}
	
	
	
	
	
	
	

}
