package com.cr.Practice;

public class Student {
private String name;
private int id;
private String branch;
Student(String name,int id,String branch){
	this.name=name;
	this.id=id;
	this.branch=branch;
}
public String toString() {
	return "Student name="+name+"  id="+id+"  branch="+branch+"]";
}
}
