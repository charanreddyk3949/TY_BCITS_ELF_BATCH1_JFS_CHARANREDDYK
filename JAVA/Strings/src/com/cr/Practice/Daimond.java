package com.cr.Practice;

import java.util.Scanner;

public class Daimond
{
	public static void main(String[] args) 
	{
		 System.out.println("enter a number");
		    Scanner scn=new Scanner(System.in);
		    int a=scn.nextInt();
		    int spaces=a/2+1;
		    int stars=1;
		    for(int i=1;i<=a;i++)
		    {
		    	for(int j=1;j<=spaces;j++)
		    	{
		    		System.out.print(" ");
		    	}
		    	for(int j=1;j<=stars;j++)
		    	{
		    		if(j==1||j==stars)
		    		System.out.print("*");
		    		else System.out.print(" ");
		    	}
		    	 System.out.println();
				    if(i<=a/2)
				    {
				    	stars+=2;
				    	spaces--;
				    }
				    else
				    {
				    	stars-=2;
				    	spaces++;
				    }
		    }
		   
	}

}
