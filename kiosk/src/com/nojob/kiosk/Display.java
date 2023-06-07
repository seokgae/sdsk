package com.nojob.kiosk;

public class Display {
	static void drawHead() {
//		clearScreen();
		System.out.println("* * * * * * * * * * * * * * * * *");
		System.out.println("*                               *");
		System.out.println("*             cafe              *");
		System.out.println("*                               *");
		System.out.println("* * * * * * * * * * * * * * * * *");
	}
	
	static void drawKioskMain() {
		System.out.println("--------------------------------");
		System.out.println("    1.메뉴 2.결제 3.관리메뉴 x.종료   ");
		System.out.println("--------------------------------");
		System.out.print("명령: ");
	}
	
	 static void drawOrder() {
		 int i = 1;
		 System.out.print("메뉴 : ");
		for(Product key: Kiosk.menus) {
			System.out.print(i+":"+key.name+" "); i++;
		}
		System.out.print("e.결제하기 x.뒤로가기 /  명령: ");
	}
	
	static void drawAdmin() {
		System.out.println("-----------------------------------------");
		System.out.println("1.매출확인 2.매출초기화 3.메뉴추가 4.메뉴확인 x.종료");
		System.out.println("-----------------------------------------");
		System.out.print("명령: ");
	}
	 
	public static void clearScreen() {
		for (int i = 0; i < 80; i++)System.out.println("\b");
		for (int i = 0; i < 80; i++)System.out.println("");
		for (int i = 0; i < 80; i++)System.out.println("\b");
	}
}


