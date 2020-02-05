package com.bcits.discomusecase.beans;

import java.util.Scanner;

public class TariffBillGeneratorClass {
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter No. of Units...");
		Double units=scanner.nextDouble();
		System.out.println("enter One type of Consumer...1.Residential \n 2.Commertial \n 3.Industrial");
		String consumerType=scanner.next();
		Double bill=TariffBillGenerator.getBill(units, consumerType);
		
		System.out.println(bill);
	}//End of main

}//End of class
