package com.nojob.games.logic;

public class MinesLogic {
	public static MinesDiff easy = new MinesDiff(10, 8, 12);
	public static MinesDiff normal = new MinesDiff(36, 11, 10);
	public static MinesDiff hard = new MinesDiff(76, 14, 9);
	
	public void genField(MinesDiff dif, MButton[][] MineField) {
		int MinesNum = dif.Mines();
		int row = dif.row(); int col = dif.col();

		while (MinesNum != 0) {
			int x = (int) (Math.random() * row);
			int y = (int) (Math.random() * col);
			if (MineField[x][y].bomb == 0) {
				MineField[x][y].bomb = -9;
				MinesNum--;
			}
		}
		
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < col; y++) {
				adjcheck(x, y, row, col, MineField);
			}
		}
	}

	private void adjcheck(int x, int y, int row, int col, MButton[][] MineField) {
		if (MineField[x][y].bomb < 0) {
			if (x == 0) {
				if (y == 0) {LT(x, y, MineField);}
				else if(y == col-1) {RT(x, y, MineField);}
				else {TOPBorder(x, y, MineField);}
			} 
			else if (x == row-1) {
				if (y == 0) {LB(x, y, MineField);}
				else if(y == col-1) {RB(x, y, MineField);}
				else {BOTBorder(x, y, MineField);}
			}
			else if (y == 0 && (x > 0 && x < row-1)){ LBorder(x, y, MineField);}
			else if (y == col-1 && (x > 0 && x < row-1)){ RBorder(x, y, MineField);}
			else {Inside(x, y, MineField);}
		}
	}
	
	private void LT(int x, int y, MButton[][] MineField) {
		/**********************//***********************//********************/
		/**********************/					  	 MineField[x][y+1].bomb++;
		/**********************/MineField[x+1][y].bomb++;MineField[x+1][y+1].bomb++;
	}
	private void RT(int x, int y, MButton[][] MineField) {
		/********************//****************************//********************/
		MineField[x][y-1].bomb++;					        /********************/
		MineField[x+1][y-1].bomb++;MineField[x+1][y].bomb++;/********************/
	}
	private void LB(int x, int y, MButton[][] MineField) {
		/********************/MineField[x-1][y].bomb++;MineField[x-1][y+1].bomb++;
		/********************/				  	  	   MineField[x][y+1].bomb++;
		/********************//***********************//********************/
	}
	private void RB(int x, int y, MButton[][] MineField) {
		MineField[x-1][y-1].bomb++;MineField[x-1][y].bomb++;/********************/
		MineField[x][y-1].bomb++;  				            /********************/
		/************************//************************//********************/
	}
	private void LBorder(int x, int y, MButton[][] MineField) {
		/********************/MineField[x-1][y].bomb++;MineField[x-1][y+1].bomb++;
		/********************/					  	   MineField[x][y+1].bomb++;
		/********************/MineField[x+1][y].bomb++;MineField[x+1][y+1].bomb++;
	}
	private void TOPBorder(int x, int y, MButton[][] MineField) {
		/*************************//***********************//********************/
		MineField[x][y-1].bomb++;  				     	    MineField[x][y+1].bomb++;
		MineField[x+1][y-1].bomb++;MineField[x+1][y].bomb++;MineField[x+1][y+1].bomb++;
	}
	private void RBorder(int x, int y, MButton[][] MineField) {
		MineField[x-1][y-1].bomb++;MineField[x-1][y].bomb++;/********************/
		MineField[x][y-1].bomb++;  				            /********************/
		MineField[x+1][y-1].bomb++;MineField[x+1][y].bomb++;/********************/
	}
	private void BOTBorder(int x, int y, MButton[][] MineField) {
		MineField[x-1][y-1].bomb++;MineField[x-1][y].bomb++;MineField[x-1][y+1].bomb++;
		MineField[x][y-1].bomb++;  				      	    MineField[x][y+1].bomb++;
		/************************//************************//********************/
	}
	private void Inside(int x, int y, MButton[][] MineField) {
		MineField[x-1][y-1].bomb++;MineField[x-1][y].bomb++;MineField[x-1][y+1].bomb++;
		MineField[x][y-1].bomb++;  				      	    MineField[x][y+1].bomb++;
		MineField[x+1][y-1].bomb++;MineField[x+1][y].bomb++;MineField[x+1][y+1].bomb++;
	}

}
