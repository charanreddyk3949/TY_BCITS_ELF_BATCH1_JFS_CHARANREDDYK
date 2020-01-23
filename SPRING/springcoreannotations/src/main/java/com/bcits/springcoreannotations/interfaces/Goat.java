package com.bcits.springcoreannotations.interfaces;

public class Goat implements Animal {

	@Override
	public void eat() {
		System.out.println("Eating grass..");

	}

	@Override
	public void speak() {
		System.out.println(" mehh! mehh!");

	}

}
