package com.nojob.kiosk;

import java.util.HashMap;

public class SalesLog {
	public int TotalTake = 0;
	public HashMap<Product, Integer> SalesLogEach = new HashMap<>();
	
	public void ConsoleLog() {
		System.out.println(TotalTake);
	}
}
