package com.bcits.jpawithhibernateapp.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bcits.jpawithhibernateappinsert.beans.EmployeePrimaryInfo;

@Entity
@Table(name="employee_secondary_info")
public class EmployeeSecondaryInfo {
	@Id
	private int empid;
	@Column
	private String gender;
	@Column
	private String personalmailid;
	@Column
	private int age;
	@Column
	private String nationality ;
	@Column
	private String ismarried;
	@Column
	private String govtid;
	@Column
	private String guardianname;
	@Column
	private long guardiancontactno;
	@Column
	private String joblocation;
	
	
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empid")
	private EmployeePrimaryInfo primay;
	
	
	
	public EmployeePrimaryInfo getPrimay() {
		return primay;
	}
	public void setPrimay(EmployeePrimaryInfo primay) {
		this.primay = primay;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPersonalmailid() {
		return personalmailid;
	}
	public void setPersonalmailid(String personalmailid) {
		this.personalmailid = personalmailid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getIsmarried() {
		return ismarried;
	}
	public void setIsmarried(String ismarried) {
		this.ismarried = ismarried;
	}
	public String getGovtid() {
		return govtid;
	}
	public void setGovtid(String govtid) {
		this.govtid = govtid;
	}
	public String getGuardianname() {
		return guardianname;
	}
	public void setGuardianname(String guardianname) {
		this.guardianname = guardianname;
	}
	public long getGuardiancontactno() {
		return guardiancontactno;
	}
	public void setGuardiancontactno(long guardiancontactno) {
		this.guardiancontactno = guardiancontactno;
	}
	public String getJoblocation() {
		return joblocation;
	}
	public void setJoblocation(String joblocation) {
		this.joblocation = joblocation;
	}
	

}
