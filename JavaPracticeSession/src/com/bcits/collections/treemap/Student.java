package com.bcits.collections.treemap;

import java.util.*;

public class Student implements Comparable<Student> {
	
	int age;
	String name;
	
	Student(int age,String name){
		this.age=age;
		this.name=name;
	}

public String toString() {
	return "Student[id="+age+"  name="+name+"]";
}
	@Override
	public int compareTo(Student o) {
		
		return this.age - o.age;
	}
	
	

}
