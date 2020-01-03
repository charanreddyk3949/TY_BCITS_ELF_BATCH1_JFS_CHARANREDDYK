package com.ty.bcits.datastructures.sortsolution;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class SortSolution1 {
    public static void main(String[] args) {
	@SuppressWarnings("resource")
	Scanner scanner=new Scanner(System.in);
	System.out.println("enter number of student details....");
	int n=scanner.nextInt();
	
	TreeMap<Student, Integer> t1=new TreeMap<Student, Integer>();
	for (int i = 0; i < n; i++) {
		System.out.println("enter studet id ....");
	    int id=scanner.nextInt();
	    System.out.println("enter name........");
	    String name=scanner.next();
	    System.out.println("enter cgpa...");
	    int cgpa=scanner.nextInt();
		t1.put(new Student(id,name), cgpa);
		Set<Entry<Student, Integer>> s1=t1.entrySet();
		for (Entry<Student, Integer> entry : s1) {
			System.out.println(entry.getKey());
			
		}
		
    }
}
    }