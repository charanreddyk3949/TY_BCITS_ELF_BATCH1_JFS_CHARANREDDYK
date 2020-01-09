package com.bcits.datastructures.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class OneDArray {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Array Size....");
		int n=scanner.nextInt();
		int[] a=new int[n];
		for (int i = 0; i < n; i++) {
		     System.out.println("Enter "+i+" element");
		     int m=scanner.nextInt();
		     a[i]=m;
		
		}
		for (int i : a) {
			System.out.println(i);
		}
	}
}