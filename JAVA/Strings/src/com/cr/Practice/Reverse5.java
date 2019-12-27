package com.cr.Practice;

import java.util.Scanner;

public class Reverse5 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter a String:");
		String str=scn.nextLine();
		String s2="";
		String []s1=str.split(" ");
		for(int i=0;i<=s1.length-1;i++) {
			s2+=reverse1(s1[i])+' ';
			
		}
		System.out.println(s2);


	}
static String reverse1(String s) {
	String s3=" ";
	for(int i=s.length()-1;i>=0;i--) {
		s3+=s.charAt(i);
	}
	return s3;
	
}
}
