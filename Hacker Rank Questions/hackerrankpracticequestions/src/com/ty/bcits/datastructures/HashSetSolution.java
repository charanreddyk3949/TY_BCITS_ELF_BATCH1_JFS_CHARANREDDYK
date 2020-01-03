package com.ty.bcits.datastructures;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HashSetSolution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the number of pairs....");
		int n = Integer.parseInt(scanner.nextLine());
		HashSet<String> set = new HashSet<String>();
         ArrayList<Integer> al=new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			System.out.println("enter the  " + i + "  pair...");
		    String fullname =  scanner.nextLine();
			int count = 0;
			set.add(fullname);
			for (Object o : set) {
				count++;
			}
			al.add(count);
			

		}
		for(int num:al) {
			System.out.println(num);
		}

	}

}
