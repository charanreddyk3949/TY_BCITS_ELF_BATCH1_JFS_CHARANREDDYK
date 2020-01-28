package com.bcits.fileoperations.bufferwriting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriting {
	public static void main(String[] args) {
		try {
			FileWriter fr=new FileWriter("D:\\fileoperations\\outputb1.txt");
			BufferedWriter br=new BufferedWriter(fr);
			String str="Java full stack developers";
			br.write(str);
			br.close();
			System.out.println("writing is successfull ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
