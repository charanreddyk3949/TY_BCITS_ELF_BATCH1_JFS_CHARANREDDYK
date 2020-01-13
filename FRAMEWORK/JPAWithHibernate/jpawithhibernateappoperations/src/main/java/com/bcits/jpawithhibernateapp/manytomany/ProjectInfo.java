package com.bcits.jpawithhibernateapp.manytomany;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.bcits.jpawithhibernateappinsert.beans.EmployeePrimaryInfo;

import lombok.Data;
@Data
@Entity
@Table(name="project_info")
public class ProjectInfo implements Serializable {
	@Id
	@Column
	private int projid;
	@Column
	private String projname;
	@Column
	private String technology;
	@Column
	private Date startdate;
	@Column
	private Date enddate;
	@Column
	private String location;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "project_info",joinColumns = @JoinColumn(name="projid"),inverseJoinColumns = @JoinColumn(name="empid"))
	
	private List<EmployeePrimaryInfo> primaryInfos;
}
