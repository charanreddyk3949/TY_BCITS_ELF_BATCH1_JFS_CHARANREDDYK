package com.ty.bcits.datastructures;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapSolution {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the number of entries in phone book...");
		int n = scanner.nextInt();
		Map<String, Long> entry = new LinkedHashMap<String, Long>();
		String name = null;
		long phno = 0;
		for (int i = 1; i <= n; i++) {
			System.out.println("enter the name ...");
			name = scanner.next();
			System.out.println("enter the phone number...");
			phno = scanner.nextLong();
			entry.put(name, phno);

		}
		System.out.println(entry);

		System.out.println("enter the number of queries...");
		int q = scanner.nextInt();
		for (int i = 1; i <= q; i++) {
			System.out.println("enter the name for search...");
			String str = scanner.next();
            
			if(entry.get(str)!=null){
				System.out.println(str+"="+entry.get(str));
			}else {
				System.out.println("details not found");
			}
			}

		}
	}

