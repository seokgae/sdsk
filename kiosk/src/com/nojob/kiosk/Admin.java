package com.nojob.kiosk;

public class Admin {
	String AdminPswrd = "mario34";

	public void run() {
		System.out.print("비밀번호 입력:");
		String pswd_input = Kiosk.sc.next();
		if (pswd_input.equals(AdminPswrd)) {
			inAdmin: while (true) {
				Display.drawAdmin();
				String temp = Kiosk.sc.next();
				switch (temp) {
				case "1":
					System.out.println(Kiosk.totalsum);
					break;
				case "2":
					Kiosk.totalsum = 0;
					break;
				case "3":
					System.out.print("메뉴명:");
					String new_menuname = Kiosk.sc.next();
					System.out.print("\n");
					System.out.print("가격:");
					Integer new_menuprice = Integer.parseInt(Kiosk.sc.next());
					System.out.print("\n");
					Kiosk.menus.add(new Product(new_menuname, new_menuprice));
					System.out.println("추가완료!");
					break;
				case "4":
					int i = 1;
					for (Product key : Kiosk.menus) {
						System.out.print(i + "." + key.name + ":"+key.price+"원 ");
						i++;
					}
					System.out.print("\n");
					break;
				case "x":
					Main.sel.main();
				}
			}
		}
	}
}
