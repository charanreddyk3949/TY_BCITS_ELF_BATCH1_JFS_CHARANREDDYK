package org.cr.ptrns;

import java.util.Scanner;

public class Demo4 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter no.of lines:");
		int n=scn.nextInt();
		int spaces=n-1;
		for(int i=1;i<=n;i++) {
			for(int j=i;j<=spaces;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print("*");
			}
		System.out.println( );
		}

	}

}
