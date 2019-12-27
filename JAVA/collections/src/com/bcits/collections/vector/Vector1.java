package com.bcits.collections.vector;

import java.util.Vector;

public class Vector1 {
	public static void main(String[] args) {
		Vector<Integer> v=new Vector<Integer>();
		v.add(10);
		v.add(20);
		v.add(30);
	
		System.out.println(v);
		v.add(1, 50);
		System.out.println(v);
		v.remove(0);
		System.out.println(v);
		System.out.println(v.isEmpty());
		System.out.println("---------------");
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
			
		}
		System.out.println(v.contains(20));
		System.out.println("---------------");
		v.setElementAt(99, 0);
		System.out.println(v);
		System.out.println("---------------");
		v.removeElement(99);
		System.out.println(v);
		System.out.println("-----insertElementAt()-------");
		v.insertElementAt(10, 1);
		System.out.println(v);
		System.out.println("---------------");
		v.removeElement(99);
		System.out.println("-----------trimToSize()---------");
		System.out.println(v.size());
		System.out.println(v.capacity());
		v.trimToSize();
		System.out.println(v.size());
		v.ensureCapacity(10);
		System.out.println("---------ensureCapacity()------------");
		System.out.println(v.capacity());
		v.setSize(15);
		System.out.println(v.capacity());
		
	}

}
