package com.cr.prblms;

public class InsersionSort {
  public static void iSort(int[]a) {
	  for(int i=1;i<a.length-1;i++) {
		  int key=a[i];
		  int j=i-1;
		  while(j>=0&&a[j]>key) {
			  a[j+1]=a[j];
			  j--;
		  }
		  a[j+1]=key;
	  }
  }

	public static void main(String[] args) {
		int[]a= {8,1,7,4,2,9};
		iSort(a);
		for(int a1:a) {
			System.out.println(a1);
		}

	}

}