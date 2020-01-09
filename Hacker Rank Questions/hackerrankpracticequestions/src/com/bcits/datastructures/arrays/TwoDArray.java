package com.bcits.datastructures.arrays;

import java.util.Scanner;

public class TwoDArray {	
		public static void main(String[] args)
	    {
			Scanner scanner=new Scanner(System.in);
	        int a[][] = new int[6][6];
	        int maxSum = 0;
	        int sum=0;
	        
	            for( int i = 0; i < 6; i++)
	            {
	                for(int  j = 0; j < 6; j++)
	                {
	                	System.out.println("enter "+i+j+" element...");
	                    a[i][j] = scanner.nextInt();
	                    if (i > 1 && j > 1)
	                    {
	                         sum =
	                            a[i][j]+ a[i][j-1]+ a[i][j-2]
	                            	   + a[i-1][j-1]+
	                           a[i-2][j]+ a[i-2][j-1]+ a[i-2][j-2];
	                        if (sum > maxSum) {
	                        	maxSum = sum;
	                        	}
	                    }
	                    
	                }
	            }
	            System.out.println(maxSum);
	        }
	        
		
	    }
	