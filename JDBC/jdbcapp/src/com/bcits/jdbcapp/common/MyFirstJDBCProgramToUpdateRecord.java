package com.bcits.jdbcapp.common;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirstJDBCProgramToUpdateRecord {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		
		
		
			try {
				//load the "Driver"
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				//get connection via driver
				String dbUrl="jdbc:mysql://localhost:3306/employee_management_info?user=root&password=root";
				con=DriverManager.getConnection(dbUrl);
				//issue the Sql Queries
				String query="update employee_primary_info set name='santhosh' where empid=13";
				stmt=con.createStatement();
				int i=stmt.executeUpdate(query);
				System.out.println("no of rows affected-->"+i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
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
