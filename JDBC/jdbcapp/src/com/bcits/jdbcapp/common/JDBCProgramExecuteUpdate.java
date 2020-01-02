package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBCProgramExecuteInsert {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		int i=0;
		// load the "Driver "
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//get the "Connection" via "Driver"
			String dbUrl="jdbc:mysql://localhost:3306/employee_management_info?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			
	
			//"Issue the Sql Queries"
			String query = "insert into employee_primary_info values(14,'charanreddy',7708069999,'charanar@gmail.com','1998-12-09','2018-12-28','tester','b+',40000,10,06)";
			stmt = con.createStatement();
			i= stmt.executeUpdate(query);
			
			//"process the result set" return by connection
			System.out.println("no of rows affected-->"+i);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		finally {
			try {
				if (con != null) {
					con.close();
				}
				
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} // end 
		}
	}//main ends
}//class ends
