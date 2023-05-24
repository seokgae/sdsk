package com.nojob.kiosk;

public class Display {
	static void drawHead() {
//		clearScreen();
		System.out.println("============================================");
		System.out.println("==============     고양이카페     =============");
		System.out.println("============================================");
	}
	
	static void drawKioskMain() {
		System.out.println("------------------------");
		System.out.println("    1.구매 2.내역 x.종료   ");
		System.out.println("------------------------");
		System.out.print("명령: ");
	}
	
	 static void drawOrder() {
		System.out.print("메뉴 : 1.아메리카노 2.카페라테 3.에스프레소 x.뒤로가기");
		System.out.print(" 명령: ");
	}
	
	public static void clearScreen() {
		for (int i = 0; i < 80; i++)System.out.println("\b");
		for (int i = 0; i < 80; i++)System.out.println("");
		for (int i = 0; i < 80; i++)System.out.println("\b");
	}
}


