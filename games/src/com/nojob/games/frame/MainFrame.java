package com.nojob.games.frame;

import javax.swing.*;

import com.nojob.games.events.*;

public class MainFrame extends JFrame {//메인윈도우
	public static JPanel overlay = new JPanel();//오버레이 패널 생성
	public static ButtonEventMain events = new ButtonEventMain();//공용 버튼 이벤트 객체 생성 


	public MainFrame() {
		setSize(500, 900);
		setTitle("GAMES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		overlay.setLayout(null);
						
		StartScreen startScreen = new StartScreen();
		overlay.add(startScreen);
		
		add(overlay);
		
		setResizable(false);
		setVisible(true);
	}
}
