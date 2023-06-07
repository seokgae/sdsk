package com.nojob.kiosk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Kiosk {
//	static HashMap<Product, Integer> menus = new HashMap<>();
	public static ArrayList<Product> menus = new ArrayList<>();
	public static Product Americano = new Product("Americano", 1500);
	public static Product CafeLatte = new Product("CafeLatte", 2500);
	public static Product Espresso = new Product("Espresso", 2000);
	public static String adminPwsd = "mario34";
	public static Scanner sc = new Scanner(System.in);
	
	public static int totaltake = 0;
	public static int totalsum = 0;
	String cmd;
	
	
	public Kiosk() {
		menus.add(Americano);
		menus.add(CafeLatte);
		menus.add(Espresso);
	}

	void run() {
		Display.drawKioskMain();
		cmd = Kiosk.sc.next();
		
		if(cmd.equals("1")) {
			Main.sel.order();
		}
		else if(cmd.equals("2")) {
			Main.sel.purchase();
		}
		else if(cmd.equals("3")) {
			Main.sel.admin();
		}
		else if(cmd.equals("x")) {
			Main.sel.exit = true;
		}
	}
	
	
	
	public static int total_sum() {
		totalsum = 0; 
		for(Product key:menus) {
			totalsum += key.price*key.ea;
		}
		return totalsum;
	}

	public static int total_take() {
		totaltake = 0;
		
		for(Product key:menus) {
			totaltake += key.price*key.ea_sold;
		}
		return totaltake;
	}

}
