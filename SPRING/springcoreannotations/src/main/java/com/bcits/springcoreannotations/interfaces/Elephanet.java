package com.bcits.springcoreannotations.interfaces;

public class Elephanet implements Animal {

	@Override
	public void eat() {
		System.out.println(" Eating sugarCane");

	}

	@Override
	public void speak() {
		System.out.println(" Making Elephant Sound");

	}

}
