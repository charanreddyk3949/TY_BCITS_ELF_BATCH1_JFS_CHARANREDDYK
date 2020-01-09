package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class PreparedStatementInsert {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		 
		java.util.Date dt = new java.util.Date("10/12/1999"); 
		java.sql.Date sqlDt=new java.sql.Date(dt.getDate());
		
		java.util.Date doj = new java.util.Date("12/03/2017"); 
		java.sql.Date sqlDoj=new java.sql.Date(doj.getDate());
		
		
			try {
				
				//load the "Driver"
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				//get connection via driver
				String dbUrl="jdbc:mysql://localhost:3306/employee_management_info?user=root&password=root";
				con=DriverManager.getConnection(dbUrl);
				//issue the Sql Queries
				String query="insert into employee_primary_info  values(?,?,?,?,?,?,?,?,?,?,?)";
				 pstmt=con.prepareStatement(query);
				 
			    pstmt.setInt(1, Integer.parseInt(args[0]));
				pstmt.setString(2, args[1]);
				pstmt.setLong(3, Integer.parseInt(args[2]));
				pstmt.setString(4, args[3]);
				pstmt.setDate(5, sqlDt);
				pstmt.setDate(6, sqlDoj);
				pstmt.setString(7, args[4]);
				pstmt.setString(8, args[5]);
				pstmt.setInt(9, Integer.parseInt(args[6]));
				pstmt.setInt(10, Integer.parseInt(args[7]));
				pstmt.setInt(11, Integer.parseInt(args[8]));
				
				
				
				int i=pstmt.executeUpdate();
				System.out.println("no of rows affected-->"+i);
				
				if(i>0) {
					System.out.println("record is inserted ");
				}else {
					System.out.println("record is not inserted");
				}
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

 

