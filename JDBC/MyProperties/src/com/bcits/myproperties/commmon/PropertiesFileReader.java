package com.bcits.myproperties.commmon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesFileReader {
	public static void main(String[] args) {
		try {
			FileInputStream inputStream=new FileInputStream("dbInfo.properties");
			Properties properties=new Properties();
			properties.load(inputStream);
			System.out.println("Driver name--->"+properties.get("driveNm"));
			System.out.println("dbUrl --->"+properties.get("dbUrl"));
			System.out.println("user name --->"+properties.get("user"));
			System.out.println("password --->"+properties.get("password"));
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//end method

}//end class
