package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample {
	
	public static void main(String[] args) {
		
		          Connection con=null;
		          PreparedStatement pstmt=null;
		          ResultSet rs=null;
		
				try {
					//1. Load the Driver
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					
					//2.Get connection via driver
					String dbUrl="jdbc:mysql://localhost:3306/employee_management_info";
					 con=DriverManager.getConnection(dbUrl, "root", "root");
					
					//3.Issue the SQL Queries via Connection
					String query=" select * from employee_primary_info "
							+ " where empid=? " ;
					 pstmt=con.prepareStatement(query);
					pstmt.setInt(1, Integer.parseInt(args[0]));
					rs=pstmt.executeQuery();
					
					// 4."Process the result" returned by "SQL Queries"
					if (rs.next()) {
						int employeeID = rs.getInt("empid");
						String employeeNM = rs.getString("name");
						long EmployeeMBNO = rs.getLong("mobileno");
						String employeeMLID = rs.getString("officialmailid");
						Date employeeDOB = rs.getDate("dateofbirth");
						Date employeeDOJ = rs.getDate("dateofjoining");
						String employeeDSIG = rs.getString("designation");
						String employeeBLDG = rs.getString("bloodgroup");
						Double employeeSAL = rs.getDouble("salary");
						int employeeDID = rs.getInt("deptid");
						int employeeMID = rs.getInt("managerid");

						System.out.println("Employee Id ===>" + employeeID);
						System.out.println("Employee Name ===>" + employeeNM);
						System.out.println("Employee MobileNo ===>" + EmployeeMBNO);
						System.out.println("Employee MailId ===>" + employeeMLID);
						System.out.println("Employee DateOfBirth ===>" + employeeDOB);
						System.out.println("Employee DateOfJoining ===>" + employeeDOJ);
						System.out.println("Employee Designation ===>" + employeeDSIG);
						System.out.println("Employee BloodGroup ===>" + employeeBLDG);
						System.out.println("Employee Salary ===>" + employeeSAL);
						System.out.println("Employee DepartmentID ===>" + employeeDID);
						System.out.println("Employee ManagerID ===>" + employeeMID);
						System.out.println("---------------------------------------");

					}else {
						System.err.println("Employee data not found in DB");
					}
					
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {

					// 5.close all the " JDBC Objects"
					try {
						if (con != null) {
							con.close();
						}
						if (rs != null) {
							rs.close();
						}
						if (pstmt != null) {
							pstmt.close();
						}
					} catch (SQLException e) {

						e.printStackTrace();
					} // end of try catch block

				} // end finally

			}// main end
		}// end clas