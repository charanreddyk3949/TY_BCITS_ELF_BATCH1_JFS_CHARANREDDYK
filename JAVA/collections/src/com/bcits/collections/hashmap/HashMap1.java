package com.bcits.collections.hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap1 {
	public static void main(String[] args) {
		HashMap<Integer, String>h1=new HashMap<Integer, String>();
		h1.put(24, "babi");
		h1.put(45, "raj");
		h1.put(89, "ammu");
		h1.put(23,"vinodh");
		Set<Map.Entry<Integer,String>> s1=h1.entrySet();
		for (Map.Entry<Integer, String> entry : s1) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("--------------");
		}
			System.out.println(h1.get(89));
			Set<Integer> s2=h1.keySet();
			for (Integer integer : s2) {
				System.out.println(integer);
				
			}
			Collection<String>s3=h1.values();
			for (String string : s3) {
				System.out.println(string);
				
			}
		}
	
}
