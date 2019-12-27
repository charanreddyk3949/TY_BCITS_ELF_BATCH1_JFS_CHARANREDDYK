package com.bcits.collections.Prctice;

import java.util.ArrayList;
import java.util.Collection;

public class Collection2 {
	public static void main(String[] args) {
		Collection<Integer> c1=new ArrayList<Integer>();
		c1.add(10);
		c1.add(20);
		Collection<Integer> c2=new ArrayList<Integer>();
		c2.add(30);
		c2.add(20);
		c2.add(40);
		System.out.println(c1);
		System.out.println(c2);
		c2.addAll(c1);
		System.out.println("------------------");
		System.out.println(c1);
		System.out.println(c2);
		
		c2.removeAll(c1);
		System.out.println("------------------");
		System.out.println(c1);
		System.out.println(c2);
		
		System.out.println("------------------ratainAll and containsAll-------------");
		Collection<Integer> c3=new ArrayList<Integer>();
		c3.add(10);
		c3.add(20);
		Collection<Integer> c4=new ArrayList<Integer>();
		c4.add(30);
		c4.add(20);
		c4.add(40);
		System.out.println(c3.containsAll(c4));
		System.out.println(c3);
		System.out.println(c4);
		c4.retainAll(c3);
		System.out.println("-------------------retainAll--------------------");
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c4.isEmpty());
		System.out.println("-------------toArray----------");
		Object [] o1=c3.toArray();
		for (int i= 0;  i< o1.length;i ++) {
			System.out.println(o1[i]);
		}
	}

}
