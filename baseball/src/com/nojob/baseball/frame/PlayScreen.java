package com.nojob.baseball.frame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.event.KeyListener;
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

public class PlayScreen extends JPanel {

	public PlayScreen() { //// 인게임 화면
		setLayout(null);
		setSize(500, 900);

		JPanel header = new JPanel();
		JPanel middle = new JPanel();
		JPanel footer = new JPanel();
		header.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		middle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		footer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		middle.setPreferredSize(new Dimension(485, 500));
		JScrollPane scroll = new JScrollPane(middle, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		header.setBounds(0, 0, 500, 150);
		scroll.setBounds(0, 180, 485, 500);
		footer.setBounds(0, 700, 500, 200);
		add(header);
		add(scroll);
		add(footer);

		setHeader(header);// setFooter쪽으로 start랑 timer넘겨야됨
		setFooter(footer, middle, scroll);

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

//	public void setMiddle(JPanel middle) {//	}

	public void setFooter(JPanel footer, JPanel middle, JScrollPane scroll) {
//		NumberFormatter range = new NumberFormatter();
//		range.setValueClass(Integer.class);
//		range.setMinimum(4);
//		range.setMaximum(4);
//		JFormattedTextField input = new JFormattedTextField(range);
//		input.setPreferredSize(new Dimension(80,40));
		JTextField input = new JTextField("", 20);

		input.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				String str="";
				char temp = e.getKeyChar();
				int temp_num = Character.getNumericValue(temp);
				if (temp >= 49 && temp <= 57 && MainFrame.inputnums.size() < 4) {//입력이 정수이면
					int cnt = 0;
					for(Integer I:MainFrame.inputnums) {//중복체크 시작
						if (I == temp_num) {cnt++;break;}
					}
					if(cnt == 0) {MainFrame.inputnums.add(temp_num);}//중복이 아니면
					else {
						for (Integer I : MainFrame.inputnums) {str += Integer.toString(I);}
						input.setText(str);
					}
				}
				else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {MainFrame.inputnums.remove(MainFrame.inputnums.size()-1);}
				else {
					for (Integer I : MainFrame.inputnums) {str += Integer.toString(I);}
					input.setText(str);
				}
			}
		});
		JButton submit = new JButton("확인");
//		JPanel startScreen = startScreen();
		// todo input validity check
		submit.addActionListener(MainFrame.events.new submitOnClick(middle, input, scroll));

		footer.add(input);
		footer.add(submit);
	}
}
