package com.bcits.exceptionhandling.uncheckedexceptions;

public class Calculator {
	
	public void add(int a,int b) {
		System.out.println(a+b);
	}
	public void division(int a,int b) {
		try {
		System.out.println(a/b);
		}catch(ArithmeticException e)
		{
			System.out.println("Ex                                                                                                                                                                                                                                                                                                                                                          ception handled ");
		}
	}
}
