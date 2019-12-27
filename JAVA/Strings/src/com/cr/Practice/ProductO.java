package com.cr.Practice;

public class ProductO {

	public static void main(String[] args) {
		Product[]p=new Product[4];
		p[0]=new Product("iphone",30000.0,123);
		p[1]=new Product("sphone",20000.0,143);
		p[2]=new Product("rphone",10000.0,435);
		p[3]=new Product("mphone",50000.0,999);
		for(Product p1:p) {
			System.out.println(p1);
		}
	}

}
