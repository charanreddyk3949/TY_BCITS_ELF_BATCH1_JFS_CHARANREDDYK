package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementUpdate {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		
		
			try {
				//load the "Driver"
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				//get connection via driver
				String dbUrl="jdbc:mysql://localhost:3306/employee_management_info?user=root&password=root";
				con=DriverManager.getConnection(dbUrl);
				//issue the Sql Queries
				String query="update employee_primary_info set name=? where empid=?";
				 pstmt=con.prepareStatement(query);
				 pstmt.setString(1, args[0]);
				pstmt.setInt(2, Integer.parseInt(args[1]));
				int i=pstmt.executeUpdate();
				System.out.println("no of rows affected-->"+i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (con != null) {
						con.close();
					}
					
					if (pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e) {

					e.printStackTrace();
				} // end 
			}
		}//main ends
	}//class ends

 

