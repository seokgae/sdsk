package com.nojob.games.frame;

import java.awt.Dimension;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.nojob.games.events.*;
import com.nojob.games.logic.*;

public class PlayScreenMines extends JPanel {
		public static int tot_mines;
		public static int frogs;
		private JPanel header;
		private JPanel middle;
		private JPanel footer;
		static MinesDiff dif;
		static ButtonEventMines events_mines;

	public PlayScreenMines(MinesDiff dif) { //// 인게임 화면
		PlayScreenMines.dif = dif;
		events_mines = new ButtonEventMines(dif);
		setLayout(null);
		setSize(500, 900);
		tot_mines = dif.Mines();
		
		header = new JPanel();
		middle = new JPanel();
		footer = new JPanel();
		header.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		middle.setLayout(new GridLayout(dif.row(), dif.col()));///////난이도 별 레이아웃조정
		footer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		middle.setPreferredSize(new Dimension(500, 500));
		header.setBounds(0, 0, 500, 150);
		middle.setBounds(0, 150, 485, 500);
		footer.setBounds(0, 700, 500, 200);
		add(header);
		add(middle);
		add(footer);

		Timer timer = setHeader();
		setMiddle(timer);
		setFooter();

	}

	public Timer setHeader() {
		JLabel start = new JLabel("");
		JButton reset = new JButton("초기화");
		JLabel WL = new JLabel(String.format("승 : %d / 패 : %d", UserData.wins, UserData.losses));

		Timer timer = Util.newTimer(start);
		
		timer.start();
		reset.addActionListener(events_mines.new resetOnClick(header, timer, middle));
		header.add(start);
		header.add(reset);
		header.add(WL);
		
		return timer;
	}

	public void setMiddle(Timer timer) {
		int row = dif.row();
		int col = dif.col();
		MButton[][] buttons = new MButton[row][col];
		MinesLogic ar = new MinesLogic();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				buttons[i][j] = new MButton(i, j);
				buttons[i][j].setFont(dif.font);
				buttons[i][j].setBorder(BorderFactory.createCompoundBorder(
											BorderFactory.createLineBorder(Color.black, 1),
											BorderFactory.createEmptyBorder(1, 1, 1, 1)));
				buttons[i][j].addMouseListener(events_mines.new MinesClick(buttons, middle, timer));
				middle.add(buttons[i][j]);
			}
		}
		ar.genField(dif, buttons);
	}

	public void setFooter() {
		JButton toMain = new JButton("처음으로");
		toMain.addActionListener(MainFrame.events::toMain);
		
		footer.add(toMain);
	}
}
