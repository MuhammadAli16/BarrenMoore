package com.barren;

public abstract class MovingPieces {

	private int xCoord;
	private int yCoord;
	
	public MovingPieces(int xCoordPlyr, int yCoordPlyr) {
		super();
		this.xCoord = xCoordPlyr;
		this.yCoord = yCoordPlyr;
	}


	public int getxCoord() {
		return xCoord;
	}
	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	public int getyCoord() {
		return yCoord;
	}
	public void setyCoordPlyr(int yCoord) {
		this.yCoord = yCoord;
	}
	
	public void move(Direction compass){
		
		switch(compass){
		case EAST:
			this.xCoord++;
			break;
		case NORTH:
			this.yCoord++;
			break;
		case SOUTH:
			this.yCoord--;
			break;
		case WEST:
			this.xCoord--;
			break;
		}
		
		
	}
	
	
}
