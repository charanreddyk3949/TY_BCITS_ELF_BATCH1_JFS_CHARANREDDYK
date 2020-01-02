package com.cr.Practice;

import java.util.Scanner;

public class Reverse7 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter a String:");
		String str=scn.nextLine();
		String s2="";
		String []s1=str.split(" ");
		for(int i=s1.length-1;i>=0;i--) {
			s2+=s1[i]+' ';
			
		}
		System.out.println(s2);

	}

}
