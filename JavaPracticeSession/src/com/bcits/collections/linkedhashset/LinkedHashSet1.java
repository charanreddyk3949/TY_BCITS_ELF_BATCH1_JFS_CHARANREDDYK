package com.bcits.collections.linkedhashset;

import java.util.LinkedHashSet;

public class LinkedHashSet1 {
	public static void main(String[] args) {
    LinkedHashSet<Integer>l1=new LinkedHashSet<Integer>();
	l1.add(56);
	l1.add(23);
	l1.add(1);
	l1.add(98);
	l1.add(66);
	System.out.println(l1);
	l1.add(56);
	System.out.println(l1);
	l1.remove(1);
	System.out.println(l1);
	}

}
