package org.cr.ptrns;

import java.util.Scanner;

public class Demo5 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter no.of lines:");
		int n=scn.nextInt();
		int spaces=n-1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=(i-1);j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=(n-i+1);k++) {
				System.out.print("*");
			}
		System.out.println( );
		}

	}

}
