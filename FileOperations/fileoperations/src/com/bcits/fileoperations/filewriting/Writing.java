package com.bcits.fileoperations.filewriting;

import java.io.FileWriter;
import java.io.IOException;

public class Writing {
	public static void main(String[] args) {
		try {
			FileWriter fw=new FileWriter("D:\\fileoperations\\output1.txt");
			String str="java is programing lang";
			fw.write(str);
			fw.write("hello everyone how are u");
			fw.close();
			System.out.println("file writing is successfull");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
