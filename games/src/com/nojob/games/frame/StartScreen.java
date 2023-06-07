package com.nojob.games.frame;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartScreen extends JPanel {
	
	public StartScreen() { ////시작화면
		setSize(500,900);
		setLayout(null);

		JButton start = new JButton("야구게임");
		start.setBounds(150,200,100,100);
		start.addActionListener(MainFrame.events.new startOnClick());
		JButton startmines = new JButton("지뢰찾기");
		startmines.setBounds(270,200,100,100);
		startmines.addActionListener(MainFrame.events.new startOnClickMines(this));
		add(start);
		add(startmines);
	}
}
