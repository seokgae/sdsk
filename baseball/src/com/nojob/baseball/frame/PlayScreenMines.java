package com.nojob.baseball.frame;

import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.text.NumberFormatter;
import com.nojob.baseball.frame.ButtonEvent.*;
import com.nojob.baseball.logic.UserData;

public class PlayScreenMines extends JPanel {

	public PlayScreenMines() { //// 인게임 화면
		setLayout(null);
		setSize(500, 900);

		JPanel header = new JPanel();
		JPanel middle = new JPanel();
		JPanel footer = new JPanel();
		header.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		middle.setLayout(new GridLayout(8,8));
		footer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		middle.setBackground(Color.red);

		middle.setPreferredSize(new Dimension(500, 500));
		header.setBounds(0, 0, 500, 150);
		middle.setBounds(0, 150, 485, 500);
		footer.setBounds(0, 700, 500, 200);
		add(header);
		add(middle);
		add(footer);

		setHeader(header);// setFooter쪽으로 start랑 timer넘겨야됨
		setMiddle(middle);
		
	}

	public void setHeader(JPanel header) {
		JLabel start = new JLabel("");
		JButton reset = new JButton("초기화");
		JLabel WL = new JLabel(String.format("승 : %d / 패 : %d", UserData.wins, UserData.loses));

		Timer timer = Util.newTimer(start);

		timer.start();
		reset.addActionListener(MainFrame.events.new resetOnClick(header, timer, start));
		header.add(start);
		header.add(reset);
		header.add(WL);
	}

	public void setMiddle(JPanel middle) {	
		JButton[][] buttons = new JButton[8][8];
		
		for (int i =0;i<8;i++) {
			for(int j=0;j<8;j++) {
				buttons[i][j] = new JButton();
				middle.add(buttons[i][j]);
			}
		}
	}

	public void setFooter(JPanel footer, JPanel middle, JScrollPane scroll) {
	}
}
