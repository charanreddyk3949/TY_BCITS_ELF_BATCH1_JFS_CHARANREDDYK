package com.bcits.collections.treemap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap1 {
	public static void main(String[] args) {
		TreeMap<Integer, String> t1=new TreeMap<Integer, String>();
		t1.put(32, "santhosh");
		t1.put(21, "vinay");
		t1.put(78, "janu");
		Set<Map.Entry<Integer, String>> s1=t1.entrySet();
		for (Entry<Integer, String> entry : s1) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("--------------");
		}
				
		
	}

}
