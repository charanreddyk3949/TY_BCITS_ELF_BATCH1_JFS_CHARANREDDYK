package com.ty.bcits.SearchingAlgorithms;

import java.time.Duration;
import java.time.Instant;

public class LinearSearch {
  public static int lSearch(int[]a,int e) {
	  for(int i=0;i<=a.length-1;i++) {
		  if(e==a[i])return i;
	  }
	  return -1;
  }
  public static void countDurationUptoSelection(int[]a,int n) {
	    Instant start=Instant.now();
	   lSearch(a,n);
	  Instant end=Instant.now();
	  Long duration=Duration.between(start, end).toMillis();
	  double seconds=duration/1000.0;
	  System.out.println("addupto took"+seconds+"seconds");
}
	public static void main(String[] args) {
		int[]a= {1,2,3,4,5,6,7,8,9,0};
		System.out.println(lSearch(a,8));
		countDurationUptoSelection(a,8);
	}

}
