package com.member;

import java.util.Vector;
import java.util.Random;

public class Enemy extends Tank implements Runnable{
	Vector<Enemy> enemies = new Vector<Enemy>();
	int select;
	String[] directionSet = {"North","West","South","East"};
	Random random = new Random();
	public Enemy(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
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
			select = random.nextInt(directionSet.length);
			this.direction = directionSet[select];
		}
	}
	
//	public void setEnemies(Vector<Enemy> enemies){
//		this.enemies = enemies;
//	}
}
