package com.bcits.collections.treeset;

public class Student implements Comparable<Student> {
	int age;
	String name;
	Student(int age,String name){
		this.age=age;
		this.name=name;
	}
	public String toString() {
		return "Student [age="+age+"   name="+name+"]";
		
	
	}
//	@Override
 //   public int compareTo(Student o) {
	//	return this.age-o.age;
//	}
	@Override
	public int compareTo(Student o) {
		
		return this.name.compareTo(o.name);
	}

}
