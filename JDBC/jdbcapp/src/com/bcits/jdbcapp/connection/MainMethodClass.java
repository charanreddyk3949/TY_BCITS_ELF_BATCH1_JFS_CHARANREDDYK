package com.bcits.jdbcapp.connection;

public class MainMethodClass {
	public static void main(String[] args) {
     
     String dbUrl="two";
     Connection con=DriverManager.getConnection(dbUrl);
     con.toString();
     con.print();
	}

}
