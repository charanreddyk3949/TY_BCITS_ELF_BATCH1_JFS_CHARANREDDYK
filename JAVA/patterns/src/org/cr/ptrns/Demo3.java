package org.cr.ptrns;

import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter no.of lines:");
		int n=scn.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
		System.out.println( );
		}
		for(int i=1;i<=n;i++) {
			for(int j=i;j<=n-1;j++) {
				System.out.print("*");
			}
		System.out.println( );
		}

	}

}
