package com.nojob.kiosk;


public class Main {
	static Selection sel = new Selection();
	Order order = new Order();
	Purchase purchase = new Purchase();
	Admin admin = new Admin();
	Kiosk k = new Kiosk();
	
	public static void main(String[] args) {
		Main m = new Main();
//		MainFrame mainfr = new MainFrame();
		Display.drawHead();
		while(m.logic() == true) {}
		System.out.println("EE");
	}
	
	boolean logic() {
		boolean hello = true;
		
		if(sel.main) {k.run();}
		else if(sel.order) {order.run();}
		else if(sel.purchase) {purchase.run();}
		else if(sel.admin) {admin.run();}
		else if(sel.exit) {hello = false;}
		
		return hello;
	}
}

