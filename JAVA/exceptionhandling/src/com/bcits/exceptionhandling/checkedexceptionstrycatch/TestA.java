package com.bcits.exceptionhandling.checkedexceptionstrycatch;

public class TestA {
	public static void main(String[] args) {
		System.out.println("main started");
		Person p1=new Person();
		try {
		p1.clone();
		System.out.println("object is cloned");
		}catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main ended");
	}

}
