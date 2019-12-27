package com.cr.prblms;

public class Product {
  private String pname;
  private double price;
  public void setName(String pname) {
	  this.pname=pname;
  }
  public void setPrice(double price) {
	  this.price=price;
  }
  public String getName() {
	  return pname;
  }
  public double getPrice() {
	  return price;
  }
}