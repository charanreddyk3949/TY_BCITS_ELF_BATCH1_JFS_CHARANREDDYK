package com.cr.Practice;

import java.util.Scanner;

public class String4 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter a String:");
		String str=scn.nextLine();
		String s2="";
		int count=0;
		String []s1=str.split(" ");
		for(int i=0;i<=s1.length-1;i++) {
			s2+=s1[i]+count(s1[i])+' ';
			
		}
		System.out.println(s2);

	}
	static int count(String s) {
		return s.length();
	}

}
