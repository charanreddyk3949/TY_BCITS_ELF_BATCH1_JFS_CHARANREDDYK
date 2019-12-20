package com.ty.bcits.SortingAlgorithms;

import java.util.Random;

public class SelectionTime {

	public static void main(String[] args) {
		int[]a=new int[1000];
		int[]b=new int[1000];
		int[]c=new int[1000];
		for(int i=1;i<=1000;i++) {
			a[i-1]=i;	
		}
		for(int j=0;j<=b.length-1;j++) {
		 for(int i=1000;i>=1;i--) {
			b[j]=i;	
		 }
		}
		for(int i=0;i<c.length-1;i++) {
			Random rand=new Random();
			 c[i] =rand.nextInt(c.length);
       
	}
		SelectionSort.countDurationUptoSelection(a);
		SelectionSort.countDurationUptoSelection(b);
		SelectionSort.countDurationUptoSelection(c);
		
	}


	}


