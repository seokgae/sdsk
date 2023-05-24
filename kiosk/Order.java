package com.nojob.kiosk;

import java.util.Scanner;

public class Order {

	public void run() {
		inOrder: while (true) {
			Display.drawOrder();
			String order = Kiosk.sc.next();

			switch (order) {
			case "1":
				Kiosk.menus.put(Kiosk.Americano, Kiosk.menus.get(Kiosk.Americano) + 1);
				System.out.print("아메리카노 1잔 추가\n");
				break;
			case "2":
				Kiosk.menus.put(Kiosk.CafeLatte, Kiosk.menus.get(Kiosk.CafeLatte) + 1);
				System.out.print("카페라테 1잔 추가\n");
				break;
			case "3":
				Kiosk.menus.put(Kiosk.Espresso, Kiosk.menus.get(Kiosk.Espresso) + 1);
				System.out.print("에스프레소 1잔 추가\n");
				break;
			case "x":
				break inOrder;
			}
		}
	}
}
