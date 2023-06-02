package com.nojob.baseball.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
	static ArrayList<JPanel> Checks = new ArrayList<>();
	static ArrayList<Integer> inputnums = new ArrayList<>();
	static int chk_num = 0;
	static int component_height = 0;
	static JPanel overlay = new JPanel();
	static ButtonEvent events = new ButtonEvent();
	

	public MainFrame() {
		setSize(500, 900);
		setTitle("baseball");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		overlay.setLayout(null);
						
		StartScreen startScreen = new StartScreen();
		overlay.add(startScreen);
		
		add(overlay);
		
		setResizable(false);
		setVisible(true);
	}
}
