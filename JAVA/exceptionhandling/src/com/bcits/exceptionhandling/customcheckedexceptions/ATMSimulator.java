package com.bcits.exceptionhandling.customcheckedexceptions;

public class ATMSimulator {
	int balance=40000;
	void withDraw(int amt) throws InsufficientBalanceException {
		if(amt<balance) {
			System.out.println("amount is withdrawn");
		}else {
			throw new InsufficientBalanceException();
		}
	}

}
