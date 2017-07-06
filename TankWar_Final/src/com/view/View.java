package com.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class View {

	JFrame jf;
	JPanel jp1, jp2;
	JMenuBar jmb,jmb2;
	JMenu jm1,jm2;
	JMenuItem jmt1, jmt2, jmt3,jmt4,jmt5,jmt6;
	
	public View(){
		jf = new JFrame("Tank War");
		jmb = new JMenuBar();
		//create the first menu to menu bar
		jm1 = new JMenu("File(F)");
		jm1.setMnemonic('f');
		jmt1 = new JMenuItem("New");
		jmt2 = new JMenuItem("Continue");
		jmt3 = new JMenuItem("Save");
		jmt4 = new JMenuItem("Save As");
		jmt5 = new JMenuItem("Exit");
		jm1.add(jmt1);
		jm1.add(jmt2);
		jm1.add(jmt3);
		jm1.add(jmt4);
		jm1.add(jmt5);
		jmb.add(jm1);
		//create the second menu to menu bar
		jm2 = new JMenu("Help(H)");
		jm2.setMnemonic('h');
		jmt6 = new JMenuItem("Doc");
		jm2.add(jmt6);
		jmb.add(jm2);
		//create panel
		jp1 = new JPanel();
		
		//set up the jframe
		jf.setJMenuBar(jmb);
		jf.add(jp1);
		jf.setSize(600, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new View();
	}

}
