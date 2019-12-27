package com.bcits.collections.list;

import java.util.List;
import java.util.ArrayList;

public class List1 {
	public static void main(String[] args) {
		ArrayList<Integer> a1=new ArrayList<Integer>()	;
	    a1.add(10);
		a1.add(20);
		System.out.println(a1);
		a1.add(1,50);
		System.out.println(a1);
		a1.remove(1);
		System.out.println(a1);	
		a1.set(1, 30);
		a1.add(10);
		System.out.println(a1);
		System.out.println(a1.indexOf(10));
		System.out.println(a1.lastIndexOf(10));
		System.out.println(a1.get(1));
		System.out.println("------------");
		for (int i = 0; i <a1.size(); i++) { 
			System.out.println(a1.get(i));
			
		}
		System.out.println("-------------------");
		List<Integer> l1=a1.subList(0, 2);
		for (int i = 0; i <l1.size(); i++) {
			System.out.println(l1.get(i));
			
		}
		a1.addAll(1, l1);
		System.out.println(a1);
	}

}
