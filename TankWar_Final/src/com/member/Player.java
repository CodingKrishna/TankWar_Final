package com.member;

import java.util.Vector;

public class Player extends Tank{
	Vector<Bullet> playerBullets = new Vector<Bullet>();
	Bullet playerBullet = null;
	public Player(int x, int y){
		super(x,y);
	}
	
	//these function will move player tank in direction on speed
	public void moveUp(){
		y-=speed;
	}
	
	public void moveLeft(){
		x-=speed;
	}
	
	public void moveDown(){
		y+=speed;
	}
	
	public void moveRight(){
		x+=speed;
	}
	
	//shoot the bullets
	public void shoot(){
		switch(this.direction){
		case "North":
			playerBullet = new Bullet(x+10,y,"North");
			playerBullets.add(playerBullet);
			break;
		case "West":
			playerBullet = new Bullet(x+10-15,y+15,"West");
			playerBullets.add(playerBullet);
			break;
		case "South":
			playerBullet = new Bullet(x+10,y+25,"South");
			playerBullets.add(playerBullet);
			break;
		case "East":
			playerBullet = new Bullet(x+10+15,y+15,"East");
			playerBullets.add(playerBullet);
			break;
		}
		Thread playBulletThread = new Thread(playerBullet);
		playBulletThread.start();
	}
}
