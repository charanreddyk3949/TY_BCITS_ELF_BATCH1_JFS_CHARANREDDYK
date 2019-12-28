package com.ty.bcits.datastructures.sortsolution;


public class Student implements Comparable<Student>{
	int id;
	String name;
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String toString() {
		return name;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(Student o) {
		return this.id-o.id;
	}
	

}

