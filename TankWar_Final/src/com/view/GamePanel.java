package com.view;
import com.member.*;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	Player player = null;
	Vector<Enemy> enemies= new Vector<Enemy>();
	
	int enemyAmount = 5;
	
	
	//set the flag to determine the functionalities
	public GamePanel(String flag){
		player = new Player(300,200);
		//if flag is new then create enemies
		if(flag.equals("New")){
			for(int i = 0; i<enemyAmount; i++){
				Enemy enemy = new Enemy((i+1)*50,0);
				enemy.setColor("Yellow");
				enemy.setDirection("South");
			}
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, 600, 400);
		if(player.isLive()==true){
			
		}
	}
	
	public void drawTank(Graphics g, int x, int y, String direction, String type){
		//determine if the type is player or enemy
		switch(type){
		case "Player":
			g.setColor(Color.cyan);
			break;
		case "Enemy":
			g.setColor(Color.yellow);
			break;
		}
		
		switch(direction){
		case "North":
			break;
		case "West":
			break;
		case "South":
			break;
		case "East":
			break;
		}
		
		
	}
}
