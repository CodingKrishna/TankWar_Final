package com.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class StartPanel extends JPanel implements Runnable{
	int time = 0;
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, 600, 400);
		//set the time interval to display the welcome string
		if(time%2==0){
			g.setColor(Color.white);
			Font myFont = new Font("Serif",Font.BOLD, 30);
			g.setFont(myFont);
			g.drawString("Welcome To War Zone", 130, 200);
		}	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			time ++;
			this.repaint();
		}
	}
}
