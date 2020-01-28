package com.bcits.exceptionhandling.checkedexceptions;

public class Calculator {
	String name;
	void division(int a,int b) {
		try {
			Class.forName("student");
		} catch (ClassNotFoundException e) {
			
			System.out.println("class not found");
		}
	}

}
