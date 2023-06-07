package com.nojob.games.logic;

import java.awt.*;

public class MinesDiff {
	private final int Mines;
	private final int row;
	private final int col;
	public Font font;
	
	MinesDiff(int Mines, int sq, int size){//square
		this.Mines = Mines;
		this.row = sq;
		this.col = sq;
		this.font = new Font("System 보통",Font.PLAIN, size);
	}
	
	MinesDiff(int Mines, int row, int col, int size){ //rectangular
		this.Mines = Mines;
		this.row = row;
		this.col = col;
		this.font = new Font("System 보통",Font.PLAIN, size);
	}
	
	public int Mines() {
		return Mines;
	}
	public int row() {
		return row;
	}
	public int col() {
		return col;
	}
}
