package com.barren;

public class Monster extends MovingPieces {

	private static int counter = 0;
	
	private int id;
	
	
	public Monster(int xCoordPlyr, int yCoordPlyr) {
		super(xCoordPlyr, yCoordPlyr);
		this.id = ++counter;
	}

	
	
}
