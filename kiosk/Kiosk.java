package com.nojob.kiosk;

import java.util.HashMap;
import java.util.Scanner;
import com.nojob.util.*;

public class Kiosk {
	static HashMap<Product, Integer> menus = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	static Product Americano = new Product("Americano", 1500);
	static Product CafeLatte = new Product("CafeLatte", 2500);
	static Product Espresso = new Product("Espresso", 2000);
	String cmd;
	Order order = new Order();
	Purchase purchase = new Purchase();

	void run() {
		menus.put(Americano, 0);
		menus.put(CafeLatte, 0);
		menus.put(Espresso, 0);

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
			case "x":
				break main;
			}
		}
		System.out.println("프로그램 종료");
	}

}
