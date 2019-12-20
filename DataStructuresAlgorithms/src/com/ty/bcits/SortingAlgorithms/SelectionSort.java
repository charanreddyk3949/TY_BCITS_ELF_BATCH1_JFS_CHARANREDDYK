package com.ty.bcits.SortingAlgorithms;

import java.time.Duration;
import java.time.Instant;

public class SelectionSort {
	public static void sSort(int[]a) {
		for(int i=0;i<a.length-1;i++) {
			int index=i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<a[index]) {
					index=j;
				}	
				}
			if(i!=index) {
				int temp=a[index];
				a[index]=a[i];
				a[i]=temp;
			}
		}
	}
	public static void countDurationUptoSelection(int[]a) {
	    Instant start=Instant.now();
	   sSort(a);
	  Instant end=Instant.now();
	  Long duration=Duration.between(start, end).toMillis();
	  double seconds=duration/1000.0;
	  System.out.println("addupto took"+seconds+"seconds");
}

	public static void main(String[] args) {
		int[]a= {8,1,7,4,2,9};
				sSort(a);
				for(int a1:a) {
					System.out.println(a1);
				}
    countDurationUptoSelection(a);
	}

}
