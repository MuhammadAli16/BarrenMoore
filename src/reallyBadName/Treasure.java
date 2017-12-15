package reallyBadName;

import java.util.Random;

public class Treasure {

	private static int count = 0;
	
	private int id;
	private int xCoordTrs;
	private int yCoordTrs;
	private Prize prize;
	
	public Treasure(int xCoordTrs, int yCoordtrs) {
		this.id = ++count;
		this.xCoordTrs = xCoordTrs;
		this.yCoordTrs = yCoordtrs;
		
		this.prize = getPrize();
	}

	
	public int getxCoordTrs() {
		return xCoordTrs;
	}

	public void setxCoordTrs(int xCoordTrs) {
		this.xCoordTrs = xCoordTrs;
	}

	public int getyCoordTrs() {
		return yCoordTrs;
	}

	public void setyCoordTrs(int yCoordtrs) {
		this.yCoordTrs = yCoordtrs;
	}

	public int getId() {
		return id;
	}
	
	public Prize getPrize(){
		Prize[] prizes = Prize.values();
		Random random = new Random();
		return prizes[random.nextInt(prizes.length)];
	}
	
	
	
	
}
