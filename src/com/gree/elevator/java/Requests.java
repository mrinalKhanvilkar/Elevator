package com.gree.elevator.java;

public class Requests {

	public int floor = 0;
	
	//0 for down and 1 for up
	public int direction = 0;
	
	//true for from within and false for outside
	public boolean inOrOut = false;
	
	public Requests(int floor, int direction, boolean inorOut){
		this.floor = floor;
		this.direction = direction;
		this.inOrOut = inorOut;
	}
}
