package com.bcits.collections.treeset;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet1 {
	public static void main(String[] args) {
		TreeSet<Student>t1=new TreeSet<Student>(new SortName());
		t1.add(new Student(25,"babu"));
		t1.add(new Student(34,"chandra"));
		t1.add(new Student(19,"ramesh"));
		
		System.out.println(t1);
		
	}

}
