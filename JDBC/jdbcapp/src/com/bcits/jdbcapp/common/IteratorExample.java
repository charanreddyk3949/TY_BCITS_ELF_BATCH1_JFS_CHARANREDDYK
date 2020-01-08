package com.bcits.jdbcapp.common;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
	
	public static void main(String[] args) {
		
		ArrayList<String> myData=new ArrayList<String>();
		myData.add("One");
		myData.add("Two");
		myData.add("Three");
		myData.add("Four");
		myData.add("Five");
		
		Iterator<String> itr=myData.iterator();
		
		while(itr.hasNext()) {
			String val=itr.next();
		    System.out.println(val);	
		}
		
	}

}
