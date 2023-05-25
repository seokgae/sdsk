package com.nojob.kiosk;

public class Admin {
	String AdminPswrd = "mario34";
	
	public void run() {
		inPWchk: while (true) {
			System.out.print("비밀번호 입력:");
			String pswd_input = Kiosk.sc.next();
			if (pswd_input.equals(AdminPswrd)) {				
				inAdmin: while (true) {
					Display.drawAdmin();
					String temp = Kiosk.sc.next();
					switch(temp) {
					case "1":
						System.out.println(Kiosk.totalsum);
						break;
					case "2":
						Kiosk.totalsum = 0;
						break; 
					case "3":
						String new_menuinput = Kiosk.sc.next();
						String[] new_menu = new_menuinput.split(",");
						Kiosk.menus.add(new Product(new_menu[0], Integer.parseInt(new_menu[1])));
						break;
					case "4":
						int i = 1;
						for(Product key: Kiosk.menus) {
							System.out.print(i+"."+key.name+" ");i++;
						}System.out.print("\n");break;
					case "x":
						break inPWchk;
					}
				}
			}
		}
	}
}
