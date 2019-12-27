package com.bcits.collections.treemap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TreeMapCom {
	public static void main(String[] args) {
	
		TreeMap<Student, Integer>t1=new TreeMap<Student, Integer>();
		t1.put(new Student(12,"charan"), 1233);
		t1.put(new Student(97,"aaryan"), 8766);
		t1.put(new Student(22,"jaanu"), 4648);
		Set<Entry<Student, Integer>> s1=t1.entrySet();
		for (Entry<Student, Integer> entry : s1) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}

}
