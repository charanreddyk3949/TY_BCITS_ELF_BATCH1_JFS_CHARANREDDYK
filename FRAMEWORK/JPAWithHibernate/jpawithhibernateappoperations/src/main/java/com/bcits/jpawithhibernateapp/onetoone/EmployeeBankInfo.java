package com.bcits.jpawithhibernateapp.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.bcits.jpawithhibernateappinsert.beans.EmployeePrimaryInfo;

public class EmployeeBankInfo implements Serializable {

	@Id
	private int empid;
	@Column
	private int accountno;
	@Column
	private String bankname;
	@Column
	private String branchname;
	@Column
	private String ifsccode;

	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "empid")
	private EmployeePrimaryInfo info;

	public EmployeePrimaryInfo getInfo() {
		return info;
	}

	public void setInfo(EmployeePrimaryInfo info) {
		this.info = info;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public int getAccountno() {
		return accountno;
	}

	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

}
