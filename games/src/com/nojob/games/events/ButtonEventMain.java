package com.nojob.games.events;

import com.nojob.games.frame.*;
import com.nojob.games.logic.*;

import java.awt.event.*;
import javax.swing.*;

public class ButtonEventMain {
	///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////
	public class startOnClick implements ActionListener {

		public startOnClick() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			BaseballLogic.genNumber();
			JPanel playScreen = new PlayScreenBaseball();
			Util.switchScreen(playScreen);
		}
	}
	///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////
	public class startOnClickMines implements ActionListener {
		JPanel parent;
		public startOnClickMines(JPanel parent) {
			this.parent = parent;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String[] diffs = {"easy","normal","hard"};
			int result = JOptionPane.showOptionDialog(parent,"난이도 선택","",0,JOptionPane.QUESTION_MESSAGE
			/*result = 클릭한 버튼 행렬 인덱스*/				, null, diffs, diffs[0]);
			if (result == 0) {
				PlayScreenMines mines = new PlayScreenMines(MinesLogic.easy);
				Util.switchScreen(mines);
			}
			else if (result == 1) {
				PlayScreenMines mines = new PlayScreenMines(MinesLogic.normal);
				Util.switchScreen(mines);
			}
			else if (result == 2) {
				PlayScreenMines mines = new PlayScreenMines(MinesLogic.hard);
				Util.switchScreen(mines);
			}
		}
	}
	
	////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////
	public void toMain(ActionEvent e) {
		StartScreen startScreen = new StartScreen();
		Util.switchScreen(startScreen);
	}

	

	
}
