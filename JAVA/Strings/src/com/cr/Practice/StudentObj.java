package com.cr.Practice;

public class StudentObj {

	public static void main(String[] args) {
    Student []s=new Student[4];
    s[0]=new Student("charan",11,"ece");
    s[1]=new Student("ram",22,"cse");
    s[2]=new Student("hari",33,"eee");
    s[3]=new Student("vijay",44,"mech");
    for(Student s1:s) {
    	System.out.println(s1);
    }
	}

}
