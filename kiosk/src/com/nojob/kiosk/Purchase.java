package com.nojob.kiosk;

public class Purchase {
	public void run() {
		int sum = 0;
		for (Product key : Kiosk.menus) {
			sum += (key.price) * (key.ea);
			System.out.print(key.name + ":" + key.ea + " ");
		}
		System.out.print("\n총 금액: " + sum + "원\n");
		System.out.print("1.결제 2.주문취소 x.뒤로가기 명령:");
		String purchase = Kiosk.sc.next();
		switch (purchase) {
		case "1":
			for (Product key : Kiosk.menus) {
				key.ea = 0;
			}
			System.out.println("결제완료!");
			Kiosk.totalsum += sum;// todo 매출, 판매내역에 추가
		case "2":
			for (Product key : Kiosk.menus) {
				key.ea = 0;
			}
			System.out.println("주문취소");
			break;
		case "x":
			Main.sel.main();
		}
	}
}
