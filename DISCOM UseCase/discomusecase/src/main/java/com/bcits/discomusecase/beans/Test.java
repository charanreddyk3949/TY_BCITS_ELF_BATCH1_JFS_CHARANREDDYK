package com.bcits.discomusecase.beans;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		Scanner scn =new Scanner(System.in) ;
		System.out.println("Select 1.residential 2.commertial 3.industrial");
		String consumerType=scn.nextLine();
		System.out.println("Enter no. of units..");
		int units=scn.nextInt();
		double amt;
	  
     if(consumerType.equals("residential")) {
		   if(units <= 100) {
			   amt=units*4;
		   }else if(units > 100 && units <= 200) {
			   amt=(100*4)+(units-100)*5;
		   }else {
			   amt=(100*4)+(200*5)+(units-200)*8;
		   }
		   System.out.println(amt);
		   
	   }else  if(consumerType.equals("commertial")) {
		   if(units <= 1000) {
			   amt=units*10;
		   }else if(units > 1000 && units <= 2000) {
			   amt=(1000*10)+(units-1000)*15;
		   }else {
			   amt=(1000*10)+((2000-1000)*15)+(units-2000)*18;
		   }	   
		   System.out.println(amt);
	   }else if(consumerType.equals("industrial")) {
		   if(units <= 10000) {
			   amt=units*10;
		   }else if(units > 10000 && units <= 20000) {
			   amt=(10000*10)+(units-10000)*15;
		   }else {
			   amt=(10000*10)+(20000-10000)*20+(units-20000)*18;
		   }
		   System.out.println(amt);
	   }
		
	
	}//End of main
}//End of class


