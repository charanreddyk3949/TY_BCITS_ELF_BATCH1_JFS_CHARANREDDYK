package com.bcits.jdbcapp.abstraction;

public class ClassY implements Connection{

	@Override
	public Statement createStatement() {
		// TODO Auto-generated method stub
		return new ClassB();
	}

}
