package com.nojob.baseball.frame;

import javax.swing.JButton;
import javax.swing.JPanel;
import com.nojob.baseball.frame.ButtonEvent.startOnClick;

public class StartScreen extends JPanel {
	
	public StartScreen() { ////시작화면
		setSize(500,900);
		setLayout(null);

		JButton start = new JButton("시작!");
		start.setBounds(150,300,200,200);
		start.addActionListener(MainFrame.events.new startOnClick());
		JButton startmines = new JButton("시작2!");
		startmines.setBounds(350,500,200,200);
		startmines.addActionListener(MainFrame.events.new startOnClickMines());
		add(start);
		add(startmines);
	}
}
