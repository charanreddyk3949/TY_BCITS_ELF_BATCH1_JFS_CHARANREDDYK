package com.cr.Practice;

public class Product {
	String name;
	double price;
	int sno;
	Product(String name,double price,int sno){
		this.name=name;
		this.price=price;
		this.sno=sno;
	}
	public String toString() {
		return "pname="+name+"  price="+price+"  psno="+sno+"]";
	}

}
