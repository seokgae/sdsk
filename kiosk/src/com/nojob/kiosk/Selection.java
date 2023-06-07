package com.nojob.kiosk;

public class Selection {
	public boolean main = true;
	public boolean order = false;
	public boolean purchase = false;
	public boolean admin = false;
	public boolean exit = false; 
	
	void main() {
		this.main = true;
		this.order = false;
		this.purchase = false;
		this.admin = false;
	}
	void order() {
		this.main = false;
		this.order = true;
		this.purchase = false;
		this.admin = false;
	}
	void purchase() {
		this.main = false;
		this.order = false;
		this.purchase = true;
		this.admin = false;
	}
	void admin() {
		this.main = false;
		this.order = false;
		this.purchase = false;
		this.admin = true;
	}
}
