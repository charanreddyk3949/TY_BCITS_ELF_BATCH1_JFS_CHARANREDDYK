package org.cr.ptrns;

import java.util.Scanner;

public class DemoPC {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter no.of lines:");
		int n=scn.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==(n/2)+1 ||j==(n/2)+1||i==j||i+j==n+1 ||i==1||i==n||j==1||j==n)
				
				System.out.print("*");
				else
					System.out.print(" ");
			}
		System.out.println( );
		}

	}

}
