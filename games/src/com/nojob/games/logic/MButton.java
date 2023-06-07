package com.nojob.games.logic;

import javax.swing.JButton;

public class MButton extends JButton {

	public enum Clicked {
		NONE, CLICKED, FLAGGED
	}

	private final int x;
	private final int y;
	public int bomb = 0;
	public int flag = 0;// 0:none 1:flag 2:?
	public Clicked isClicked = Clicked.NONE;

	public MButton(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getx() {
		return x;
	}

	public int gety() {
		return y;
	}
	
	public Clicked NONE() {
		return Clicked.NONE;
	}
	public Clicked CLICKED() {
		return Clicked.CLICKED;
	}
	public Clicked FLAGGED() {
		return Clicked.FLAGGED;
	}

}
