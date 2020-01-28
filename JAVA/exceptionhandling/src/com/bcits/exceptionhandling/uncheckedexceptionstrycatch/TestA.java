package com.bcits.exceptionhandling.uncheckedexceptionstrycatch;

public class TestA {
	public static void main(String[] args) {
		System.out.println("main started");
		String name=null;
		try {
			System.out.println(name.length());
			System.out.println(10/0);

		}catch(ArithmeticException |NullPointerException a){
			System.out.println(a.getMessage());

		}
		System.out.println("main ended");
	}

}
