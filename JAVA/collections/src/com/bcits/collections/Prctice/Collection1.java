package com.bcits.collections.Prctice;

import java.util.ArrayList;
import java.util.Collection;

public class Collection1 {
public static void main(String[] args) {
	Collection<Integer> c=new ArrayList<Integer>();
	c.add(10);
	c.add(20);
	c.add(30);
	c.add(40);
	System.out.println(c);
	c.remove(10);
	System.out.println(c);
	c.contains(30);
	System.out.println(c.contains(30));
	System.out.println(c.size());
	
}
}
