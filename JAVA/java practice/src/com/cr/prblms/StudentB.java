package com.cr.prblms;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentB {

	public static void main(String[] args) {
		Student s1=new Student();
		s1.setName("ram");
		s1.setId(11);
		Student s2=new Student();
		s2.setName("vijay");
		s2.setId(22);
		ArrayList al=new ArrayList();
		al.add(s1.getName());
		al.add(s1.getId());
		al.add(s2.getName());
		al.add(s2.getId());
		Iterator itr=al.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		System.out.println(al);
		
		
	}

}
