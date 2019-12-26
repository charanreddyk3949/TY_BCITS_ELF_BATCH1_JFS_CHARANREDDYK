package com.bcits.collections.treeset;

import java.util.Comparator;

public class SortName implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		
		return o1.age-o2.age;
	}

}
