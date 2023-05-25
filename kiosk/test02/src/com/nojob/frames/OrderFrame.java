package com.nojob.frames;

import com.nojob.kiosk.*;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderFrame extends JPanel{
	public static boolean ReceitChk = false;
	
	public OrderFrame(Container c) {
		setPreferredSize(new Dimension(500,700));
		setBackground(Color.RED);
		ArrayList<JButton> buttons = new ArrayList<>();
		
		for(int i=0;i<Kiosk.menus.size();i++) {
			Product temp = Kiosk.menus.get(i); 
			buttons.add(new JButton(temp.name));
			add(buttons.get(i));
			buttons.get(i).addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					temp.ea += 1;
					temp.info();
					ReceitChk = true;
				}
			});
		}
		JButton exit = new JButton("뒤로가기");
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JPanel master = MainFrame.masterPanel(c);
				MainFrame.middle.removeAll();
				MainFrame.middle.add(master);
				c.validate();
				c.repaint();
				
			}
		});
		
		add(exit);
	}
}
