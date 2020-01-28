package com.bcits.fileoperations.filereading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Reading {
	public static void main(String[] args) {
		
		
		try {
			FileReader fr=new FileReader("D:\\fileoperations\\output1.txt");
			int ch=fr.read();
			while(ch!= -1) {
				System.out.print((char)ch);
				ch=fr.read();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

		
	}

}
