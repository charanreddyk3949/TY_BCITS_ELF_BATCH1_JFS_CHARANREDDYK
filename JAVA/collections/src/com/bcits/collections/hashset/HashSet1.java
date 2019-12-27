package com.bcits.collections.hashset;

import java.util.HashSet;

public class HashSet1 {
	public static void main(String[] args) {
		HashSet<Integer>h1=new HashSet<Integer>();
		h1.add(45);
		h1.add(87);
		h1.add(2);
		h1.add(49);
		System.out.println(h1);
		h1.add(2);
		System.out.println(h1);
		h1.remove(87);
		System.out.println(h1);
		h1.add(null);
		System.out.println(h1.size());
		System.out.println(h1.contains(2));
		}

}
