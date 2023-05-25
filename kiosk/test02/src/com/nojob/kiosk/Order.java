package com.nojob.kiosk;

import java.util.Scanner;

public class Order {

	public void run() {
		inOrder: while (true) {
			Display.drawOrder();
			String order = Kiosk.sc.next();
			
			for(int i=0;i<Kiosk.menus.size();i++) {
				if(Integer.toString(i+1).equals(order)) {
					Kiosk.menus.get(i).eaPlus();
					System.out.println(Kiosk.menus.get(i).name+"1개 추가");
					break;
				}
				else if(order.equals("x")) {
					break inOrder;
				}
			}
		}
	}
}
