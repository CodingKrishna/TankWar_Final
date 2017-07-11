package com.member;

import java.util.Vector;

import java.util.Random;

public class Enemy extends Tank implements Runnable{
	int bulletTimeInterval;
	Vector<Enemy> enemies = new Vector<Enemy>();
	private Vector<Bullet> enemyBullets = new Vector<Bullet>();
	int select;
	String[] directionSet = {"North","West","South","East"};
	Random random = new Random();
	//constructor
	public Enemy(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	//get the enemyBullets vector
	public Vector<Bullet> getEnemyBullets() {
		return enemyBullets;
	}
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
			switch(this.direction){
			case "North":
				for(int i = 0; i<30;i++){
					y-=speed;
					//set the time interval between each move
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case "West":
				for(int i = 0; i<30;i++){
					x-=speed;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case "South":
				for(int i = 0; i<30;i++){
					y+=speed;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case "East":
				for(int i = 0; i<30;i++){
					x+=speed;
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			}
			this.bulletTimeInterval++;
			if(bulletTimeInterval%2==0){
				//determine if the enemy tank need to reload
				if(getIsLive()){
					if(enemyBullets.size()<2){
						Bullet enemyBullet = null;
						//reload new bullet
						switch(this.getDirection()){
						case "North":
							enemyBullet = new Bullet(this.getX()+10,this.getY(),"North");
							enemyBullets.add(enemyBullet);
							break;
						case "West":
							enemyBullet = new Bullet(this.getX()-5, this.getY()+15,"West");
							enemyBullets.add(enemyBullet);
							break;
						case "South":
							enemyBullet = new Bullet(this.getX()+10, this.getY()+25,"South");
							enemyBullets.add(enemyBullet);
							break;
						case "East":
							enemyBullet = new Bullet(this.getX()+25, this.getY()+15,"East");
							enemyBullets.add(enemyBullet);
							break;
						}
						
						//start the bullet thread
						Thread enemyBulletThread = new Thread(enemyBullet);
						enemyBulletThread.start();
					}
				}
				
			}
			
			//Randomly choose the direction of enemy tank
			select = random.nextInt(directionSet.length);
			this.direction = directionSet[select];
		}
	}
	
//	public void setEnemies(Vector<Enemy> enemies){
//		this.enemies = enemies;
//	}
}
