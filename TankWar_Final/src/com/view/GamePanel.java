package com.view;
import com.member.*;
import com.member.Player;
import com.member.Bullet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener, Runnable{
	Player player = null;
	Vector<Enemy> enemies= new Vector<Enemy>();
	
	int enemiesAmount = 5;
	
	
	//set the flag to determine the functionalities
	public GamePanel(String flag){
		player = new Player(300,200);
		//if flag is new then create enemies and enemy bullets
		if(flag.equals("New")){
			for(int i = 0; i<enemiesAmount; i++){
				Enemy enemy = new Enemy((i+1)*100,0);
				enemy.setDirection("South");
				Thread enemyThread = new Thread(enemy);
				enemyThread.start();
				Bullet enemyBullet = new Bullet(enemy.getX()+10,enemy.getY()+30,"South");
				enemy.getEnemyBullets().add(enemyBullet);
				Thread enemyBulletThread = new Thread(enemyBullet);
				enemyBulletThread.start();
				enemies.add(enemy);
			}
		}
	}
	
	//function of paint need JPanel.
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, 600, 400);
		//draw player tank
		if(player.getIsLive()==true){
			this.drawTank(g, player.getX(), player.getY(), player.getDirection(), "Player");
			
		}
		
		//draw the player bullets
		for(int playerBulletIndex = 0; playerBulletIndex<player.getPlayerBullets().size();playerBulletIndex++){
			Bullet playerBullet = player.getPlayerBullets().get(playerBulletIndex);
//			//draw the bullet
			if(playerBullet!=null && playerBullet.getIsLive()==true){
				g.setColor(Color.WHITE);
				g.draw3DRect(playerBullet.getBulletX(), playerBullet.getBulletY(), 2, 1, false);
			}
			if(playerBullet.getIsLive() == false){
				player.getPlayerBullets().remove(playerBullet);
			}
		}
		
		//draw the enemy tank
		for(int i =0; i<enemies.size();i++){
			Enemy enemy = enemies.get(i);
			if(enemy.getIsLive()){
				this.drawTank(g, enemy.getX(), enemy.getY(), enemy.getDirection(), "Enemy");
				for(int enemyBulletIndex  = 0; enemyBulletIndex<enemy.getEnemyBullets().size();enemyBulletIndex++){
					Bullet enemyBullet = enemy.getEnemyBullets().get(enemyBulletIndex);
					if(enemyBullet.getIsLive()){
						g.setColor(Color.RED);
						g.draw3DRect(enemyBullet.getBulletX(), enemyBullet.getBulletY(), 2, 1, false);
					}else{
						enemy.getEnemyBullets().remove(enemyBullet);
					}
				}
			}
		}
	}
	
	//function to render all tanks
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
			//draw tanks left foot
			g.fill3DRect(x, y, 5, 30,false);
			//draw the tanks right foot
			g.fill3DRect(x+15, y, 5, 30,false);
			//draw the body of the tank
			g.fill3DRect(x+5, y+5, 10, 20, true);
			//draw the weapon room
			g.setColor(Color.red);
			g.fillOval(x+5, y+10, 10, 10);
			//draw the weapon
			g.drawLine(x+10, y+15, x+10, y);
			break;
		case "West":
			//draw right foot tank
			g.fill3DRect(x+10-15, y+15-10, 30, 5,false);
			//draw left foot
			g.fill3DRect(x+10-15, y+15+5, 30, 5,false);
			//draw the body of the tank
			g.fill3DRect(x+10-10, y+15-5, 20, 10, true);
			//draw the weapon room
			g.setColor(Color.red);
			g.fillOval(x+10-5, y+15-5, 10, 10);
			//draw the weapon
			g.drawLine(x+10, y+15, x+10-15, y+15);
			break;
		case "South":
			//draw right foot
			g.fill3DRect(x, y, 5, 30,false);
			//draw left foot
			g.fill3DRect(x+15, y, 5, 30,false);
			//draw the body of the tank
			g.fill3DRect(x+5, y+5, 10, 20, true);
			//draw the weapon room
			g.setColor(Color.red);
			g.fillOval(x+5, y+10, 10, 10);
			//draw the weapon
			g.drawLine(x+10, y+15, x+10, y+25);
			break;
		case "East":
			//draw left foot
			g.fill3DRect(x+10-15, y+15-10, 30, 5,false);
			//draw right foot
			g.fill3DRect(x+10-15, y+15+5, 30, 5,false);
			//draw the body of the tank
			g.fill3DRect(x+10-10, y+15-5, 20, 10, true);
			//draw the weapon room
			g.setColor(Color.red);
			g.fillOval(x+10-5, y+15-5, 10, 10);
			//draw the weapon
			g.drawLine(x+10, y+15, x+10+15, y+15);
			break;
		}
		
		
	}

	//this will control the move of player tank and it need key listener
	@Override
	public void keyPressed(KeyEvent k) {
		// TODO Auto-generated method stub
		if(k.getKeyCode()==KeyEvent.VK_W){
			player.setDirection("North");
			player.moveUp();
			
		}
		if(k.getKeyCode()==KeyEvent.VK_A){
			player.setDirection("West");
			player.moveLeft();
		}
		if(k.getKeyCode()==KeyEvent.VK_S){
			player.setDirection("South");
			player.moveDown();
		}
		if(k.getKeyCode()==KeyEvent.VK_D){
			player.setDirection("East");
			player.moveRight();
		}
		//if press key "J" then player will shoot
		if(k.getKeyCode() == KeyEvent.VK_J){
			this.player.shoot();
		}
		//after pressed the key, Panel will refresh to show the new move of player
		this.repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//implements the thread
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//call repaint every 100 ms to refresh the game panel
			this.repaint();
		}
	}
}
