package com.bcits.hackerranksolutions.strings;

import java.util.Scanner;

public class SubString {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the string...");
		String str=scanner.nextLine();
		System.out.println("Enter the start and end index...");
		int i=scanner.nextInt();
		int j=scanner.nextInt();
//		for (int k = i; k < j; k++) {           
//			System.out.print(str.charAt(k));     ///Another method
//		}
		System.out.println(str.substring(i, j-1));
		
		
		
		
		
	}

}
