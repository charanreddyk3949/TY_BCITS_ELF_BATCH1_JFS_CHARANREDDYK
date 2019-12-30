package com.bcits.jdbcapp.connection;

public class DriverManager {

	public static Connection getConnection(String str) {
		// some business logic
		Connection ref = null;
		if (str.equals("one")) {
			ref = new ClassA();
		} else {
			ref = new ClassB();
		}
		return ref;

	}// End method

}// End class
