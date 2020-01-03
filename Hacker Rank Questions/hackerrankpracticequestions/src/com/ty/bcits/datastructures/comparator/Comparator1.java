package com.ty.bcits.datastructures.comparator;

import java.util.Arrays;
import java.util.Scanner;
public class Comparator1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter number of players....");
		int n = scanner.nextInt();
		Player[] p1 = new Player[n];
		Check c1 = new Check();
		for (int i = 0; i < n; i++) {
			System.out.println("enter name...");
			System.out.println("enter score....");
			p1[i] = new Player(scanner.next(), scanner.nextInt());
		}
		Arrays.sort(p1,c1);
		
		for (int i = p1.length-1; i >=0 ; i--) {
			System.out.println(p1[i]);
		}
		scanner.close();
	}
}
