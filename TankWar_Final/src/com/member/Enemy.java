package com.member;

import java.util.Vector;

public class Enemy extends Tank{
	Vector<Enemy> enemies = new Vector<Enemy>();
	public Enemy(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
//	public void setEnemies(Vector<Enemy> enemies){
//		this.enemies = enemies;
//	}
}
