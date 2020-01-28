package com.bcits.exceptionhandling.customuncheckedexception;

public class Election {
	void vote(int age) {
		if(age>18) {
			System.out.println("allow him to vote");
		}else {
			throw new AgeLimitException();
		}
	}

}
