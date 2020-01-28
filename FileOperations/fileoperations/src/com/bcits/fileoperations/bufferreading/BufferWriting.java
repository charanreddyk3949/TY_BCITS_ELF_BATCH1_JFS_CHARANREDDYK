package com.bcits.fileoperations.bufferreading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriting {
	public static void main(String[] args) {
		try {
			FileReader fr=new FileReader("D:\\fileoperations\\outputb1.txt");
			BufferedReader br=new BufferedReader(fr);
			String ch=br.readLine();
			while(ch!= null) {
				System.out.print(ch);
				ch=br.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
