package com.cr.Practice;

import java.util.Scanner;

public class StringrReo7 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter a String:");
		String str=scn.nextLine();
		String s2="";
		String []s1=str.split(" ");
		for(int i=0;i<=s1.length-1;i++) {
			if(isEven(i)) {
				s2+=s1[s1.length-1]+' ';
			}
			else {
				s2+=s1[i];
			     }
			
		}
		System.out.println(s2);


	}
	public static boolean isEven(int i) {
	if(i/2==0) 	return true;
	return false;
	
	
    }

}
