package com.nojob.games.events;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;

import com.nojob.games.frame.*;
import com.nojob.games.logic.*;

public class ButtonEventBaseball {
	///////////////////////////////////////////////////////
	////////////////////초기화이벤트//////////////////////////
	///////////////////////////////////////////////////////
	public class resetOnClick implements ActionListener {
		JPanel middle;
		JPanel header;
		JLabel start;
		Timer timer;

		public resetOnClick(JPanel header, Timer timer, JLabel start) {
			this.header = header;
			this.timer = timer;
			this.start = start;
		}

		@Override
		public void actionPerformed(ActionEvent e) { // 초기화 버튼 클릭 이벤트
			timer.stop();
			int result = JOptionPane.showConfirmDialog(middle, "다시시작하면 패배로 기록되고 게임을 리셋합니다.", "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (result == 0) {
				UserData.mines_losses++;
				PlayScreenBaseball baseball = new PlayScreenBaseball();
				Util.switchScreen(baseball);
			}
			else if (result == 2||result == -1) {
				timer.start();
			}
		}
	}

	///////////////////////////////////////////////////////
	//////////////////// 숫자확인이벤트/////////////////////////
	///////////////////////////////////////////////////////
	public class submitOnClick implements ActionListener {
		JPanel middle;
		JTextField input;
		JScrollPane scroll;
		Timer timer;

		public submitOnClick(JPanel middle, JTextField input, JScrollPane scroll, Timer timer) {
			this.middle = middle;
			this.input = input;
			this.scroll = scroll;
			this.timer = timer;
//		this.startScreen = startScreen;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			BaseballLogic.logic(PlayScreenBaseball.inputnums);
			PlayScreenBaseball.inputnums.clear();

			PlayScreenBaseball.Checks.add(new JPanel());

			JPanel temp = PlayScreenBaseball.Checks.get(PlayScreenBaseball.chk_num);

			temp.setLayout(new GridLayout(1, 1));
			temp.setPreferredSize(new Dimension(141, 60));
			temp.add(new JLabel(
					"[" + input.getText() + " S:" + BaseballLogic.strikes + "개 / B:" + BaseballLogic.balls + "개]"));
			middle.add(temp);
			if (PlayScreenBaseball.Checks.size() % 3 == 0) {// 컴포넌트 세개 -> 한줄이 추가될때마다 한줄 높이 계산
				PlayScreenBaseball.component_height += 90;
			}
			if (middle.getHeight() < PlayScreenBaseball.component_height) {
				middle.setPreferredSize(new Dimension(485, PlayScreenBaseball.component_height));
				middle.validate();
				middle.repaint();
				scroll.validate();
				scroll.repaint();// 줄 높이가 middle패널 보다 커지면 확장
			} else {
				middle.validate();
				middle.repaint();
			}
			PlayScreenBaseball.chk_num++;
			input.setText(null);// 확인 후 입력창 비우기

			if (BaseballLogic.strikes == 4) {
				timer.stop();
				UserData.wins++;
				int result = JOptionPane.showConfirmDialog(middle, "승리! 다시하시겠습니까?", "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
				if (result == 0) {
					PlayScreenBaseball baseball = new PlayScreenBaseball();
					Util.switchScreen(baseball);
				}
				else if (result == 1||result == -1) {
					StartScreen start = new StartScreen();
					Util.switchScreen(start);
				}
			}
		}
	}
}
