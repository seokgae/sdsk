package com.nojob.kiosk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import com.nojob.util.*;

public class Kiosk {
//	static HashMap<Product, Integer> menus = new HashMap<>();
	public static ArrayList<Product> menus = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	public static Product Americano = new Product("Americano", 1500);
	public static Product CafeLatte = new Product("CafeLatte", 2500);
	public static Product Espresso = new Product("Espresso", 2000);
	
	static int totalsum = 0;
	String cmd;
	Order order = new Order();
	Purchase purchase = new Purchase();
	Admin admin = new Admin();

	void run() {
		menus.add(Americano);
		menus.add(CafeLatte);
		menus.add(Espresso);

		main: while (true) {
			Display.drawHead();
			Display.drawKioskMain();
			cmd = sc.next();
			switch (cmd) {
			case "1":
				order.run();
				break;
			case "2":
				purchase.run();
				break;
			case"3":
				admin.run();
				break;
			case "x":
				break main;
			}
		}
		System.out.println("프로그램 종료");
	}

}
