package com.ty.bcits.datastructures;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class List1Solution {
	 static Scanner scanner=new Scanner(System.in);
	 static List<Integer> list=null;
	public static void main(String[] args) {
		System.out.println("enter the size of the list...");
		int n =Integer.parseInt(scanner.nextLine());
		list=new ArrayList(n);
		for (int i =0 ; i < n; i++) {
			System.out.println("enter the element at"+i+" position");
			list.add(i,Integer.parseInt(scanner.nextLine()));
			
		}
		System.out.println(list.toString());
		System.out.println("enter the number of queries....");
		int q=Integer.parseInt(scanner.nextLine());
		
		for (int i =1; i <= q; i++) {
			System.out.println("enter the option of Insert/delete..");
			String query=scanner.nextLine();
			if(query.equalsIgnoreCase("insert")) {
				System.out.println("enter the position for insertion..");
				int y=Integer.parseInt(scanner.nextLine());
				System.out.println("enter the value to be inserted..");
				int x=Integer.parseInt(scanner.nextLine());
				list.add(y, x);
				
			}else if(query.equalsIgnoreCase("delete")) {
				System.out.println("enter the position to be deleted...");
				int d=Integer.parseInt(scanner.nextLine());
				list.remove(d);
			}else {
				System.err.println("enter the valid query");
			}
			System.out.println(list.toString());
		}
	}
	
	

}
