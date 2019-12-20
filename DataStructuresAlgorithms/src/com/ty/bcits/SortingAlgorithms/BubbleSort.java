package com.ty.bcits.SortingAlgorithms;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class BubbleSort {
    public static void sort(int[] a) {
    	for(int i=0;i<a.length-1;i++) {
    		for(int j=0;j<a.length-1-i;j++) {
    			if(a[j]>a[j+1]) {
    				int temp=a[j];
    				a[j]=a[j+1];
    				a[j+1]=temp;
    			}
    		}
    	}
    }
    public static void countDurationUptoBubble(int[]a) {
		    Instant start=Instant.now();
		   sort(a);
		  Instant end=Instant.now();
		  Long duration=Duration.between(start, end).toMillis();
		  double seconds=duration/1000.0;
		  System.out.println("addupto took"+seconds+"seconds");
    }

    public static void main(String[]args) {
    	int[]a= {1,5,26,9};
		sort(a);
		for(int a1:a) {
			System.out.println(a1);
		}
		
	}
    }

	


