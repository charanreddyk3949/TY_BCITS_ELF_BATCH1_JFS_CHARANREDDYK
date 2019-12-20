package com.ty.bcits.SearchingAlgorithms;

import java.time.Duration;
import java.time.Instant;

public class BinarySearch {
    public static int bSearch(int []a,int e) {
    	int l=0;
    	int h=a.length-1;
    	while(l<=h) {
    		int m=(l+h)/2;
    		if(e==a[m])return m;
    		else if(e>a[m])return l=m+1;
    		else
    			return h=m-1;
    	}
		return -1;
    	
    }
    public static int binarySearch(int arr[],  int key){  
    	int first=0;
    	int last=arr.length-1;
    	   int m = (first + last)/2;  
    	   while( first <= last ){  
    	      if ( arr[m] < key ){  
    	        first = m + 1;     
    	      }else if ( arr[m] == key ){  
    	        System.out.println("Element is found at index: " + m);  
    	        break;  
    	      }else{  
    	         last = m - 1;  
    	      }  
    	      m= (first + last)/2;  
    	   }  
    	  
		return -1;
		  
    	 }     
    	 
    public static void countDurationUptoSelection(int[]a,int n) {
	    Instant start=Instant.now();
	   bSearch(a,n);
	  Instant end=Instant.now();
	  Long duration=Duration.between(start, end).toMillis();
	  double seconds=duration/1000.0;
	  System.out.println("addupto took"+seconds+"seconds");
}
	public static void main(String[] args) {
		int[]a= {1,2,3,4,5,6,7,8,9};
		System.out.println(binarySearch(a,4));
		countDurationUptoSelection(a,1);
	}

	}


