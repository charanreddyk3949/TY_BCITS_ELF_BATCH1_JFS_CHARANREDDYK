package com.bcits.exceptionhandling.uncheckedexceptions;

public class TestA {
	public static void main(String[] args) {
		System.out.println("main Starts");
		Calculator c1=new Calculator();
		c1.division(100, 5);
		c1.division(100, 0);
		c1.division(20, 5);
		c1.division(100, 20);
		System.out.println("main ends");
	}

}
