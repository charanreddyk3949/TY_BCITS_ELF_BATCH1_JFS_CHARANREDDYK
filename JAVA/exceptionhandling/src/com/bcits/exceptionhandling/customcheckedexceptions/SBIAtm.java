package com.bcits.exceptionhandling.customcheckedexceptions;

public class SBIAtm {
   public static void main(String[] args) {
	   System.out.println("main Started ");
	ATMSimulator a1=new ATMSimulator();
	
	try {
		a1.withDraw(41000);
	} catch (InsufficientBalanceException e) {
		System.out.println(e.getMessage());
	}
	System.out.println("main ended");
}
}
