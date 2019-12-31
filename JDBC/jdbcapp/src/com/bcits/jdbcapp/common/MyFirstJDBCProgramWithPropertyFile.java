package com.bcits.jdbcapp.common;

import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MyFirstJDBCProgramWithPropertyFile {
	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;

		try {
			// 1. Load the "Driver".
			
			/*
			 * Driver driveRef = new Driver(); DriverManager.registerDriver(driveRef);
			 */
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// 2.Get the "DB Connection" via "Driver "
			String dbUrl = "jdbc:mysql://127.0.0.1:3306/employee_management_info";
			
//			FileInputStream file=new FileInputStream("db.properties");
			FileReader reader = new FileReader("db.properties");
			Properties prop=new Properties();
			prop.load(reader);
			//String dbUrl = "jdbc:mysql:// 10.10.13.222:3306/employee_management_info?user=root&password=root";
			

			//con = DriverManager.getConnection(dbUrl);
			
			con = DriverManager.getConnection(dbUrl, prop);
 
			// 3.Issue "SQL Queries" via "Connection"
			String query = "Select * from employee_primary_info";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			// 4."Process the result" returned by "SQL Queries"
			while (rs.next()) {
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

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			// 5.close all the " JDBC Objects"
			try {
				if (con != null) {
					con.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} // end of try catch block

		} // end finally

	}// main end
}// end class

