package com.bcits.collections.iteratingwaysforlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListIterating {
	public static void main(String[] args) {
		ArrayList<Integer>al=new ArrayList<Integer>();
		al.add(10);
		al.add(20);
		al.add(30);
		System.out.println(al);
		System.out.println("--------using for loop-------------");
		for (int i = 0; i <al.size(); i++) {
			System.out.println(al.get(i));
		}
		System.out.println("--------using foreach loop----------");
		for(Integer i1:al) {
			System.out.println(i1);
		}
		System.out.println("----------using iterator -----------");
		Iterator<Integer> itr=al.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());                          
			
		}
		System.out.println("----------using List Iterator on forward order---------");
		ListIterator<Integer> lstr=al.listIterator();
		while(lstr.hasNext()) {
		System.out.println(lstr.next());
		}
		System.out.println("----------using List Iteratoron reverse direction---------");
		ListIterator<Integer> lstr1=al.listIterator(al.size());
		while(lstr1.hasPrevious()) {
			System.out.println(lstr1.previous());
		}
		
	}
	
	}
