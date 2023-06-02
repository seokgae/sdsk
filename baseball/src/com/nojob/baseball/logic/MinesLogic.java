package com.nojob.baseball.logic;

public class MinesLogic {
//	public static int MinesNum;
	public static BombFlag[][] MineField = new BombFlag[8][8];

	enum BombFlag {
		NONE, ADJACENT, BOMB// NONE=0,ADJACENT=1,BOMB=2
	}

	void genField(int MinesDiff) {
		int MinesNum = MinesDiff;

		while (MinesNum != 0) {
			int x = (int) Math.random() * 9;
			int y = (int) Math.random() * 9;
			if(MineField[x][y] == BombFlag.NONE) {
				MineField[x][y] = BombFlag.BOMB;
				MinesNum--;
			}
		}
		
		

//			MineField[i-1][j-1];
//			MineField[i-1][j];
//			MineField[i-1][j+1];
//			MineField[i][j-1];
//			MineField[i][j+1];
//			MineField[i+1][j-1];
//			MineField[i+1][j];
//			MineField[i+1][j+1];
		}

	}
}
