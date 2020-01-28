package com.bcits.exceptionhandling.uncheckedexceptionsnestedtrycatch;

public class TestA {
	public static void main(String[] args) {
		String name=null;
		System.out.println("main started");
		try {
			try {
				System.out.println(10/0);
			}catch(ArithmeticException a) {
				System.out.println(a.getMessage());
			}
			System.out.println(name.length());
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main ended");
}

}
