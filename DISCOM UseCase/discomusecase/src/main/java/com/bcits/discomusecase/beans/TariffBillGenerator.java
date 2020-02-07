package com.bcits.discomusecase.beans;

public class TariffBillGenerator {
	
	Double units;
	String consumerType;
	 Double amount;
	
	public Double getBill(Double units,String consumerType) {
		if(consumerType.equalsIgnoreCase("Residential")) {
			 if(units <= 100) {
				 amount=units*4;
			   }else if(units > 100 && units <= 200) {
				   amount=(100*4)+(units-100)*5;
			   }else {
				   amount=(100*4)+(200*5)+(units-200)*8;
			   }
			 
		}else if(consumerType.equalsIgnoreCase("Commertial")) {
			 if(units <= 1000) {
				 amount=units*10;
			   }else if(units > 1000 && units <= 2000) {
				   amount=(1000*10)+(units-1000)*15;
			   }else {
				   amount=(1000*10)+((2000-1000)*15)+(units-2000)*18;
			   }	   	
		}else if(consumerType.equalsIgnoreCase("Industrial")) {
			if(units <= 10000) {
				amount=units*10;
			   }else if(units > 10000 && units <= 20000) {
				   amount=(10000*10)+(units-10000)*15;
			   }else {
				   amount=(10000*10)+(20000-10000)*20+(units-20000)*18;
			   }	   	 
		}
		
		return  amount;
	}//End of getBill()

}//End of class
