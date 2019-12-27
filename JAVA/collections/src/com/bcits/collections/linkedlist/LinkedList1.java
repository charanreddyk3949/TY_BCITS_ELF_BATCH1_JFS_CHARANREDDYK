package com.bcits.collections.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedList1 {
	public static void main(String[] args) {
		LinkedList<Integer>l1=new LinkedList<Integer>();
		l1.add(88);
		l1.add(98);
		l1.add(44);
		System.out.println(l1);
		l1.remove(1);
		System.out.println(l1);
		l1.add(2, 55);
		System.out.println(l1);
		l1.set(1, 99);
		System.out.println(l1);
		Iterator itr=l1.iterator();
		System.out.println("--------------------");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("--------------------");
		System.out.println(l1.size());
		System.out.println(l1.indexOf(55));
		System.out.println("-------------------");
		System.out.println(l1.get(1));
		System.out.println(l1.isEmpty());
		LinkedList<Integer>l2=new LinkedList<Integer>();
		l2.add(88);
		l2.add(98);
		l2.add(44);
		l1.addAll(l2);
		System.out.println(l1);
		Iterator itr1=l1.iterator();
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}
		
	}

}
