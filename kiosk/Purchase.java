package com.nojob.kiosk;

public class Purchase {
	public void run() {
		inPurchase: while (true) {
			int sum = 0;
			for (Product key : Kiosk.menus.keySet()) {
				sum += (key.price) * (Kiosk.menus.get(key));
			}
			System.out.print("아메리카노 : " + Kiosk.menus.get(Kiosk.Americano) 
							+ " 카페라떼 : " + Kiosk.menus.get(Kiosk.CafeLatte) 
							+ " 에스프레소 : "+ Kiosk.menus.get(Kiosk.Espresso) 
							+ "\n총 금액: " + sum + "원\n");
			System.out.print("1.결제 2.주문취소 x.뒤로가기 명령:");
			String purchase = Kiosk.sc.next();
			switch (purchase) {
			case "1":
				for (Product key : Kiosk.menus.keySet()) {
					Kiosk.menus.put(key, 0);
				}
				System.out.println("결제완료!");// todo 매출, 판매내역에 추가
				break inPurchase;
			case "2":
				for (Product key : Kiosk.menus.keySet()) {
					Kiosk.menus.put(key, 0);
				}
				System.out.println("주문취소");
				break;
			case "x":
				break inPurchase;
			}
		}
	}
}
