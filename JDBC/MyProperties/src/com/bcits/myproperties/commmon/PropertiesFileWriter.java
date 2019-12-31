package com.bcits.myproperties.commmon;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileWriter {
	public static void main(String[] args) {
		
		try {
			FileOutputStream fileOutputStream=new FileOutputStream("dbInfo.properties");
			Properties properties=new Properties();//cc
			properties.setProperty("driveNm","com.mysql.jdbc.Driver");
			properties.setProperty("dbUrl","jdbc:mysql://localhost:3306/ employee_management_info?user=root&password=root");
			properties.setProperty("user","root");
			properties.setProperty("password","root");
			try {
				properties.store(fileOutputStream, "Db detail");
				System.out.println("file created");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// end main method

}// end class
