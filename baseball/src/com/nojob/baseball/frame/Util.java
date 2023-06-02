package com.nojob.baseball.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Util {
	public static void switchScreen(JPanel panel) {
		MainFrame.overlay.removeAll();
		MainFrame.overlay.add(panel);
		MainFrame.overlay.validate();
		MainFrame.overlay.repaint();
	}
	
	public static Timer newTimer(JLabel start) {
		Timer timer = new Timer(100, new ActionListener() {
			private double time_zero = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				time_zero += 0.1;
				start.setText(String.format("경과시간: %.1f", time_zero));
			}
		});
		
		return timer;
	}
}
