package com.nojob.baseball.frame;

import com.nojob.baseball.logic.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;

public class ButtonEvent {
	///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////
	public class startOnClick implements ActionListener {

		public startOnClick() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			BaseballLogic.genNumber();
			JPanel playScreen = new PlayScreen();
			Util.switchScreen(playScreen);
		}
	}
	///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////
	public class startOnClickMines implements ActionListener {
		
		public startOnClickMines() {
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel playScreenMines = new PlayScreenMines();
			Util.switchScreen(playScreenMines);
		}
	}

	///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////
	public class resetOnClick implements ActionListener {
		JPanel middle;
		JPanel header;
		JLabel start;
		Timer timer;

		public resetOnClick(JPanel header, Timer timer, JLabel start) {
//			this.middle = middle;
			this.header = header;
			this.timer = timer;
			this.start = start;
		}

		@Override
		public void actionPerformed(ActionEvent e) { // 초기화 버튼 클릭 이벤트
			timer.stop();
			JFrame alert = new JFrame();
			alert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			alert.setSize(400, 150);
			alert.setLocation(50, 400);
			JLabel ask = new JLabel("다시시작하면 패배로 기록되고 게임을 리셋합니다.");
			JButton OK = new JButton("확인");
			OK.addActionListener(new ActionListener() {// 초기화 창 확인 클릭 이벤트
				@Override
				public void actionPerformed(ActionEvent e) {
					UserData.loses += 1;
					alert.dispose();
					PlayScreen playScreen = new PlayScreen();
					Util.switchScreen(playScreen);
				}
			});
			alert.add(ask, BorderLayout.NORTH);
			alert.add(OK);

			alert.setResizable(false);
			alert.setVisible(true);
		}
	}

	///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////
	public class submitOnClick implements ActionListener {
		JPanel middle;
		JTextField input;
		JScrollPane scroll;

		public submitOnClick(JPanel middle, JTextField input, JScrollPane scroll) {
			this.middle = middle;
			this.input = input;
			this.scroll = scroll;
//			this.startScreen = startScreen;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
//			String str = input.getText();
//			int[] inputnums = BaseballLogic.inputTointAry(str);
//			BaseballLogic.logic(inputnums);
			
			BaseballLogic.logic(MainFrame.inputnums);
			MainFrame.inputnums.clear();
			
			MainFrame.Checks.add(new JPanel());

			JPanel temp = MainFrame.Checks.get(MainFrame.chk_num);

			temp.setLayout(new GridLayout(1, 1));
			temp.setPreferredSize(new Dimension(141, 60));
			temp.add(new JLabel("[" + input.getText() + " S:" + BaseballLogic.strikes + "개 / B:" + BaseballLogic.balls + "개]"));
			middle.add(temp);
			if (MainFrame.Checks.size() % 3 == 0) {// 컴포넌트 세개 -> 한줄이 추가될때마다 한줄 높이 계산
				MainFrame.component_height += 90;
			}
			if (middle.getHeight() < MainFrame.component_height) {
				middle.setPreferredSize(new Dimension(485, MainFrame.component_height));
				middle.validate();
				middle.repaint();
				scroll.validate();
				scroll.repaint();// 줄 높이가 middle패널 보다 커지면 확장
			} else {
				middle.validate();
				middle.repaint();
			}
			MainFrame.chk_num++;
			input.setText(null);//확인 후 입력창 비우기

			if (BaseballLogic.strikes == 4) {
				UserData.wins += 1;
//				걍 시작화면으로 나르자//timer stop해줘야됨 개열받네
				JFrame alert = new JFrame();
				alert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				alert.setSize(400, 150);
				alert.setLocation(50, 400);
				JLabel ask = new JLabel("승리!");
				JButton OK = new JButton("처음으로");
				JButton again = new JButton("다시하기");

				OK.addActionListener(new ActionListener() {// alert창 확인 클릭 이벤트
					@Override
					public void actionPerformed(ActionEvent e) {
						alert.dispose();
						JPanel startScreen = new StartScreen();
						Util.switchScreen(startScreen);
					}
				});
				again.addActionListener(new ActionListener() {// alert창 다시 클릭 이벤트
					@Override
					public void actionPerformed(ActionEvent e) {
						alert.dispose();
						BaseballLogic.genNumber();
						PlayScreen playScreen = new PlayScreen();
						Util.switchScreen(playScreen);
					}
				});

				alert.add(ask, BorderLayout.NORTH);
				alert.add(OK);
				alert.add(again, BorderLayout.SOUTH);

				alert.setResizable(false);
				alert.setVisible(true);
			}
		}
	}
}
