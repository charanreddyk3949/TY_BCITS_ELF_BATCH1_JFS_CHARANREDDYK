package com.ty.bcits.SortingAlgorithms;

import java.time.Duration;
import java.time.Instant;

public class Quicksort {
	public static void quickSort(int[]a,int low,int high) {
		int i=low;
		int j=high;
		int pivot=a[(low+high)/2];
		while(i<=j) {
			while(a[i]<pivot)i++;
			while(a[j]>pivot)j--;
		if(i<=j) {
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
			i++;
			j--;
		}
		}
		if(low<j)quickSort(a,low,j);
		if(i<high)quickSort(a,i,high);
		
	}
	public static void countDurationUptoQuick(int[]a) {
	    Instant start=Instant.now();
	   quickSort(a,0,a.length-1);
	  Instant end=Instant.now();
	  Long duration=Duration.between(start, end).toMillis();
	  double seconds=duration/1000.0;
	  System.out.println("addupto took"+seconds+"seconds");
}


	public static void main(String[] args) {
		int[]a= {9,3,6,1,2,8};
		quickSort(a,0,a.length-1);
		for(int a1:a) {
			System.out.println(a1);
		}

	}

}
