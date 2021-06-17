package com.gromivchuk;

public class RobotLocation {

	private int x;
	private int y;
	private String direction;
	private int maxX;
	private int maxY;

	
	public RobotLocation(int x, int y, String direction, int maxX, int maxY) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.maxX = maxX;
		this.maxY = maxY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	//Turn implementation
	public void turn(String turn) {
		if (turn.equals("R")) {
			switch (this.direction) {
			case "E":
				this.direction="S";
				break;
			case "S":
				this.direction="W";
				break;
			case "W":
				this.direction="N";
				break;
			case "N":
				this.direction="E";
				break;
				
			}			
		}
		if (turn.equals("L")) {
			switch (this.direction) {
			case "E":
				this.direction="N";
				break;
			case "S":
				this.direction="E";
				break;
			case "W":
				this.direction="S";
				break;
			case "N":
				this.direction="W";
				break;
				
			}			
		}
	}
	
	//Move implementation
	public boolean move() {
		switch(this.direction) {
		case "E":
			if (x+1<=this.maxX) {
			this.x++;
			return true;
			} else return false;
		case "S":
			if (y-1>=0) {
			this.y--;
			return true;
			} else return false;
		case "W":
			if (x-1>=0) {
			this.x--;
			return true;
			} else return false;
		case "N":
			if (y+1<=this.maxY) {
			this.y++;
			return true;
			} else return false;
			
		}
		return false;
	}
	
}
