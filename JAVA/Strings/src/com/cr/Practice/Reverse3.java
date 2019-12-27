package com.cr.Practice;

import java.util.Scanner;

public class Reverse3 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter a String:");
		String str=scn.nextLine();
		String s2="";
		for(int i=str.length()-1;i>=0;i--) {
			s2+=str.charAt(i);
		}
		System.out.println(s2);

	}

}
