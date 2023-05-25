package com.nojob.frames;

import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
	public static JPanel outer = new JPanel();
	public static JPanel header = new JPanel();
	public static JPanel middle = new JPanel();
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Kiosk");
		
		Container c = getContentPane();
		setSize(500,900);
		setLayout(new FlowLayout());
		JPanel master = masterPanel(c);
		header.setBackground(Color.BLUE);
//		header.setSize(500,200);
		outer.add(header);
		outer.add(middle);
		middle.add(master);
		c.add(outer);
		
		outer.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		header.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
//		middle.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
//		outer.setSize(500,900);
		outer.setPreferredSize(new Dimension(500,900));
		header.setPreferredSize(new Dimension(500,200));
		middle.setPreferredSize(new Dimension(500,700));
		master.setPreferredSize(new Dimension(500,700));
		JLabel headerText1 = new JLabel("============================================");
		JLabel headerText2 = new JLabel("==================고양이카페==================");
		JLabel headerText3 = new JLabel("============================================");
		header.add(headerText1);
		header.add(headerText2);
		header.add(headerText3);
		
		setResizable(false);
		setVisible(true);
	} 
	
	public static JPanel masterPanel(Container c) {
		JPanel master = new JPanel();
		master.setBackground(Color.ORANGE);
		master.setPreferredSize(new Dimension(500,700));

		JButton buttonOrder = new JButton("주문");
		JButton buttonPurchase = new JButton("결제");
		JButton buttonAdmin = new JButton("관리메뉴");
		master.add(buttonOrder);
		master.add(buttonPurchase);
		master.add(buttonAdmin);
		
		buttonOrder.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				OrderFrame orderfr = new OrderFrame(c);
				middle.remove(master);
				middle.add(orderfr);
				c.validate();
				c.repaint();
			}
		});
		return master;
	}
}
