package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDelete {
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
				String query="delete from  employee_primary_info  where empid=?";
				 pstmt=con.prepareStatement(query);
				
				pstmt.setInt(1, Integer.parseInt(args[0]));
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

 

