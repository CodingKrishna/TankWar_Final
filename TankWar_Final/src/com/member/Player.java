package com.member;


public class Player extends Tank{
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
}
