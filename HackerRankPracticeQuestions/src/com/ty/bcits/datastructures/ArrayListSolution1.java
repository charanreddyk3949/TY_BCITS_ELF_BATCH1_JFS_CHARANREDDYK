package com.ty.bcits.datastructures;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListSolution1 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter number of lines..");
		int n=scanner.nextInt();
		ArrayList<ArrayList<Integer>> arraylists=new  ArrayList<ArrayList<Integer>>(n);
		ArrayList<Integer> arraylist=null;
		for (int i = 1; i <=n; i++) {
			System.out.println("enter number of digits for line"+i);
			int d=scanner.nextInt();
			arraylist=new ArrayList<Integer>(d);
			arraylist.add(0,d);
			for (int j = 1; j <=d; j++) {
				System.out.println("enter the element at " +j+" th position");
				 arraylist.add(scanner.nextInt());
			}
			System.out.println(arraylist.toString());
			arraylists.add(arraylist);
		}
		
		System.out.println(arraylists.toString());
	    System.out.println("enter number of queries...");
	    int q=scanner.nextInt();
	    for (int i = 1; i <=q; i++) {
	    	System.out.println("enter the line number..");
	    	int x=scanner.nextInt();
	    	System.out.println("enter the position of digit..");
	        Integer y=scanner.nextInt();
	    	System.out.println(arraylists.get(x-1).get(y-1));
			
		}
		scanner.close();
	}

}
