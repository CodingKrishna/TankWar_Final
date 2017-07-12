package com.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class View implements ActionListener{

	JFrame jf;
	StartPanel sp = null;
	JMenuBar jmb,jmb2;
	JMenu jm1,jm2;
	JMenuItem jmt1, jmt2, jmt3,jmt4,jmt5,jmt6;
	GamePanel gamePanel = null;
	StartPanel startPanel = null;
	
	public View(){
		jf = new JFrame("Tank War");
		jmb = new JMenuBar();
		//create the first menu to menu bar
		jm1 = new JMenu("File(F)");
		jm1.setMnemonic('f');
		jmt1 = new JMenuItem("New");
		jmt1.addActionListener(this);
		jmt1.setActionCommand("New");
		jmt2 = new JMenuItem("Continue");
		jmt2.addActionListener(this);
		jmt2.setActionCommand("Continue");
		jmt3 = new JMenuItem("Save");
		jmt3.addActionListener(this);
		jmt3.setActionCommand("Save");
		jmt4 = new JMenuItem("Save As");
		jmt4.addActionListener(this);
		jmt4.setActionCommand("Save As");
		jmt5 = new JMenuItem("Exit");
		jmt5.addActionListener(this);
		jmt5.setActionCommand("Exit");
		jm1.add(jmt1);
		jm1.addSeparator();
		jm1.add(jmt2);
		jm1.addSeparator();
		jm1.add(jmt3);
		jm1.addSeparator();
		jm1.add(jmt4);
		jm1.addSeparator();
		jm1.add(jmt5);
		jm1.addSeparator();
		jmb.add(jm1);
		//create the second menu to menu bar
		jm2 = new JMenu("Help(H)");
		jm2.setMnemonic('h');
		jmt6 = new JMenuItem("Doc");
		jm2.add(jmt6);
		jmb.add(jm2);
		//create start panel
		startPanel = new StartPanel();
		//create thread to call the run function
		//in start class
		Thread startPanelThread = new Thread(startPanel);
		startPanelThread.start();
		//set up the Java frame
		jf.setJMenuBar(jmb);
		jf.add(startPanel);
		jf.setSize(600, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new View();
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		
		//if click the new game
		if(a.getActionCommand().equals("New")){
			gamePanel = new GamePanel("New");
			Thread gamePanelThread = new Thread(gamePanel);
			gamePanelThread.start();
			jf.remove(startPanel);
			jf.add(gamePanel);
			jf.addKeyListener(gamePanel);
			jf.setVisible(true);
		}else if(a.getActionCommand().equals("Continue")){
			
		}else if(a.getActionCommand().equals("Save")){
			
		}else if(a.getActionCommand().equals("Save As")){
			
		}else if(a.getActionCommand().equals("Exit")){
			System.exit(0);
		}
	}

}

