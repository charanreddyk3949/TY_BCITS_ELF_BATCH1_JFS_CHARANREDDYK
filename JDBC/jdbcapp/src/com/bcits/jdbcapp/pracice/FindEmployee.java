package com.bcits.jdbcapp.pracice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FindEmployee {
	
	public static void main(String[] args) {
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		
		try {
			//Load the "Driver"
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			/*
			 * Driver dref=new Driver(); DriverManager.deregisterDriver(dref);
			 */
			
			//Get the "Connection "via "Driver"
			String dbUrl="jdbc:mysql://localhost:3306/ employee_management_info?user=root&password=root";
			con=DriverManager.getConnection(dbUrl);
			
			//"Issue the SQL Query" via "Connection"
			String query=" select * from employee_primary_info "
					+ " where empid=9 ";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
		
			//"Process the result" returned in SQL query
			
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
		}
		finally {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
