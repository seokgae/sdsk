package com.nojob.games.frame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;

import com.nojob.games.events.*;
import com.nojob.games.logic.*;

public class PlayScreenBaseball extends JPanel {
		private JPanel header;
		private JPanel middle;
		private JPanel footer;
		private JScrollPane scroll;
		private Timer timer;
		public static ButtonEventBaseball events_bb;
		public static ArrayList<JPanel> Checks;//확인용 패널 리스트
		public static ArrayList<Integer> inputnums;//input확인용 리스트
		public static int chk_num = 0;//
		public static int component_height = 0;

		
	public PlayScreenBaseball() { //// 인게임 화면
		events_bb = new ButtonEventBaseball();
		Checks = new ArrayList<>();
		inputnums = new ArrayList<>();
		
		setLayout(null);
		setSize(500, 900);

		header = new JPanel();
		middle = new JPanel();
		footer = new JPanel();
		header.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		middle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		footer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		middle.setPreferredSize(new Dimension(485, 500));
		scroll = new JScrollPane(middle, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		header.setBounds(0, 0, 500, 150);
		scroll.setBounds(0, 180, 485, 500);
		footer.setBounds(0, 700, 500, 200);
		add(header);
		add(scroll);
		add(footer);

		setHeader();
		setFooter();

	}

	public void setHeader() {
		JLabel start = new JLabel("");
		JButton reset = new JButton("다시하기");
		JLabel WL = new JLabel(String.format("승 : %d / 패 : %d", UserData.wins, UserData.losses));

		timer = Util.newTimer(start);

		timer.start();
		reset.addActionListener(events_bb.new resetOnClick(header, timer, start));
		header.add(start);
		header.add(reset);
		header.add(WL);
	}

	public void setMiddle(JPanel middle) {	}

	public void setFooter() {
		JTextField input = new JTextField("", 20);

		input.addKeyListener(new KeyListener() {///input validity
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				String str="";
				char temp = e.getKeyChar();
				int temp_num = Character.getNumericValue(temp);
				if (temp >= 49 && temp <= 57 && inputnums.size() < 4) {//입력이 정수이면
					int cnt = 0;
					for(Integer I:inputnums) {//중복체크 시작
						if (I == temp_num) {cnt++;break;}
					}
					if(cnt == 0) {inputnums.add(temp_num);}//중복이 아니면
					else {
						for (Integer I : inputnums) {str += Integer.toString(I);}
						input.setText(str);
					}
				}
				else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {inputnums.remove(inputnums.size()-1);}
				else {
					for (Integer I : inputnums) {str += Integer.toString(I);}
					input.setText(str);
				}
			}
		});
		JButton submit = new JButton("확인");
		submit.addActionListener(events_bb.new submitOnClick(middle, input, scroll, timer));
		JButton toMain = new JButton("처음으로");
		toMain.addActionListener(MainFrame.events::toMain);
		
		footer.add(input);
		footer.add(submit);
		footer.add(toMain);
	}
}
