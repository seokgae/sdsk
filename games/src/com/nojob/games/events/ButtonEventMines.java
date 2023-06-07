package com.nojob.games.events;

import java.awt.event.*;
import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.nojob.games.frame.*;
import com.nojob.games.logic.*;


public class ButtonEventMines {
	MinesDiff dif;
	
	public ButtonEventMines(MinesDiff dif) {
		this.dif = dif;
	} 
///////////////////////////////////////////////////////
///////////////////////////////////////////////////////
	public class MinesClick implements MouseListener {
		MButton[][] MineField;
		JPanel middle;
		Timer timer;
		
		
		public MinesClick(MButton[][] MineField, JPanel middle, Timer timer) {
			this.MineField = MineField;
			this.middle = middle;
			this.timer = timer;
		}

		public void mouseEntered(MouseEvent e) {	}
		public void mouseExited(MouseEvent e) {		}
		public void mousePressed(MouseEvent e) {	}
		public void mouseReleased(MouseEvent e) {	}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			MButton temp = (MButton) e.getSource();
			int x = temp.getx();
			int y = temp.gety();
			if (e.getButton() == MouseEvent.BUTTON1) {
				leftclick(x, y);
				checkvictory(timer);
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				rightclick(x, y);
				checkvictory(timer);
			}
		}

		private void rightclick(int x, int y) {
			MButton temp = MineField[x][y];
			if (temp.isClicked == temp.NONE() || temp.isClicked == temp.FLAGGED()) {
				switch (temp.flag) {
				case 0:
					temp.flag++;
					temp.setText("🚩");
					temp.isClicked = temp.FLAGGED();
					if (MineField[x][y].bomb < 0)
						PlayScreenMines.tot_mines--;
					break;
				case 1:
					temp.flag++;
					temp.setText("?");
					PlayScreenMines.tot_mines++;
					break;
				case 2:
					temp.flag = 0;
					temp.setText("");
					temp.isClicked = temp.NONE();
					break;
				}
			}
		}

		private void leftclick(int x, int y) {
			MButton temp = MineField[x][y];

			if (temp.isClicked == temp.NONE()) {
				if (temp.bomb == 0) {
					temp.setBackground(Color.gray);
					temp.isClicked = temp.CLICKED();
					temp.setEnabled(false);
					try {leftclick(x - 1, y - 1);} catch (Exception e) {}
					try {leftclick(x - 1, y); 	 } catch (Exception e) {}
					try {leftclick(x - 1, y + 1);} catch (Exception e) {}
					try {leftclick(x, y - 1);	 } catch (Exception e) {}
					try {leftclick(x, y + 1);	 } catch (Exception e) {}
					try {leftclick(x + 1, y - 1);} catch (Exception e) {}
					try {leftclick(x + 1, y);    } catch (Exception e) {}
					try {leftclick(x + 1, y + 1);} catch (Exception e) {}
				} else if (temp.bomb > 0) {
					temp.isClicked = temp.CLICKED();
					temp.setBackground(Color.yellow);
					temp.setText(Integer.toString(temp.bomb));
				} else {// bomb!
					timer.stop();
					temp.isClicked = temp.CLICKED();
					temp.setBackground(Color.red);
					temp.setText("X");
					int result = JOptionPane.showConfirmDialog(middle, "패배!다시하시겠습니까?", "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
					if (result == 0) {
						UserData.mines_losses++;
						PlayScreenMines mines = new PlayScreenMines(dif);
						Util.switchScreen(mines);
					}
					else if (result == 1) {
						UserData.mines_losses++;
						StartScreen startScreen = new StartScreen();
						Util.switchScreen(startScreen);
					}
				}
			}
		}

		private void checkvictory(Timer timer) {
			int frogs = PlayScreenMines.frogs;
			frogs = 0;
			for (int x=0;x<dif.row();x++) {
				for (int y=0;y<dif.col();y++) {
					if(MineField[x][y].isClicked ==  MineField[x][y].NONE()) frogs++;
				}
			}
			if(frogs == 0) {
				if (PlayScreenMines.tot_mines == 0) {
					timer.stop();
					int result = JOptionPane.showConfirmDialog(middle, "승리! 다시하시겠습니까?", "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
					if (result == 0) {
						UserData.mines_wins++;
						PlayScreenMines mines = new PlayScreenMines(dif);
						Util.switchScreen(mines);
					}
					else if (result == 1) {
						UserData.mines_wins++;
						StartScreen startScreen = new StartScreen();
						Util.switchScreen(startScreen);
					}
				}
				
			}
		}
	}
	///////////////////////////////////////////////////////
	///////////////////////리셋버튼//////////////////////////
	///////////////////////////////////////////////////////
	public class resetOnClick implements ActionListener {
		JPanel middle;
		JPanel header;
		Timer timer;

		public resetOnClick(JPanel header, Timer timer, JPanel middle) {
//			this.middle = middle;
			this.header = header;
			this.timer = timer;
			this.middle = middle;
		}

		@Override
		public void actionPerformed(ActionEvent e) { // 초기화 버튼 클릭 이벤트
			timer.stop();
			int result = JOptionPane.showConfirmDialog(middle, "다시시작하면 패배로 기록되고 게임을 리셋합니다.", "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (result == 0) {
				UserData.mines_losses++;
				PlayScreenMines mines = new PlayScreenMines(dif);
				Util.switchScreen(mines);
			}
			else if (result == 2||result == -1) {
				timer.start();
			}
		}
	}
	
	
}
