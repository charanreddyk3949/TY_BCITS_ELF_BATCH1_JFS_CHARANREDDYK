package com.cr.prblms;

import java.util.ArrayList;
import java.util.Iterator;
public class ProductO {

	public static void main(String[] args) {
	Product p1=new Product();
	p1.setName("iphone");
    p1.setPrice(1000.10);
    Product p2=new Product();
    p2.setName("bag");
    p2.setPrice(1000.50);
    ArrayList al=new ArrayList();
	al.add(p1.getName());
	al.add(p1.getPrice());
	al.add(p2.getName());
	al.add(p2.getPrice());
	Iterator itr=al.iterator();
	while(itr.hasNext()){
		System.out.println(itr.next());
	}
	}

}
