package com.nojob.kiosk;

public class Product {
	public String name;
	public int price;
	public int ea=0;
	public int ea_sold = 0;
	
	public Product(String name, int price){
		this.name = name;
		this.price = price;	
	}
	
	public int getPrice() {
		return price;
	}
	
	public void eaPlus() {
		this.ea++;
	}
	
	public void info() {
		System.out.println(name+" : "+price+"원"+ea);
	}
}
