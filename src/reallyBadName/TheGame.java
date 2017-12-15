package reallyBadName;

import java.util.ArrayList;
import java.util.Scanner;

public class TheGame {

	private Player pl;

	private ArrayList<Treasure> treasureList = new ArrayList<>();

	private ArrayList<MovingPieces> monsterList = new ArrayList<>();

	public void startGame() {

		String intro = "You awaken to find yourself in a barren moor, Whats your name?";
		System.out.println(intro);
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		// sc.close();
		createPlayer(name);

		String init = "Try North, East, South or West to find the treasure!";
		System.out.println(init);

		boolean inputCorrect = false;
		boolean collectedTreasure = false;
		boolean hitMonster = false;
		String userInput;

		// Keep showing until user finds treasure or enters wrong input
		do {

			try {
				Scanner sc1 = new Scanner(System.in);
				userInput = sc1.nextLine().toLowerCase();
				// sc1.reset();

				switch (userInput) {
				case "north":
					pl.move(Direction.NORTH);
					moveCloser(monsterList.get(0));
					inputCorrect = true;
					break;
				case "east":
					pl.move(Direction.EAST);
					moveCloser(monsterList.get(0));
					inputCorrect = true;
					break;
				case "south":
					pl.move(Direction.SOUTH);
					moveCloser(monsterList.get(0));
					inputCorrect = true;
					break;
				case "west":
					pl.move(Direction.WEST);
					moveCloser(monsterList.get(0));
					inputCorrect = true;
					break;
				case "cheat":
					cheats();
					break;
				case "exit":
					System.out.println("Wimp, bye");
					System.exit(0);
					break;
				default:
					System.out.println("WTH, you cant go there");
					inputCorrect = false;
					break;
				}

				collectedTreasure = checkHit(pl, treasureList.get(0));
				hitMonster = checkContact(pl, monsterList);
				System.out.println("MONSTER BOOLEAN " + hitMonster);
				
				if (hitMonster){
					break;
				}
				
				System.out.println("The dial reads: " + calculateDistance(pl, treasureList.get(0)));
				System.out.println();

			} catch (Exception e) {
				// chastise the user
				System.out.println("lol fail in do while loop");
			}

		} while (!inputCorrect || !collectedTreasure );

		if (hitMonster){
			System.out.println("You just encountered the monster, it has mauled you. You dead. lol");
		} else {
			System.out.println("You found the treasure, you win " + treasureList.get(0).getPrize());
		}
	}

	public void createPlayer(String name) {

		System.out.println("Hi " + name + ", You are at: " + 0 + ", " + 0 + ", Monsters lurk these waters so beware and find the hidden treasure!");
		pl = new Player(name, 0, 0);

		CreateTreasure();
		CreateMonster();
	}

	public void CreateTreasure() {
		final int UPPER = 5;
		final int LOWER = -5;

		int x = (int) (Math.random() * (UPPER - LOWER) + LOWER);
		int y = (int) (Math.random() * (UPPER - LOWER) + LOWER);

		Treasure t = new Treasure(x, y);
		treasureList.add(t);

	}

	public void CreateMonster() {
		final int UPPER = 5;
		final int LOWER = -5;

		int x = (int) (Math.random() * (UPPER - LOWER) + LOWER);
		int y = (int) (Math.random() * (UPPER - LOWER) + LOWER);

		MovingPieces m = new Monster(x, y);
		monsterList.add(m);

	}

	public double calculateDistance(Player pl, Treasure t) {
		double distance = Math.hypot(t.getxCoordTrs() - pl.getxCoord(), t.getyCoordTrs() - pl.getyCoord());
		return distance;
	}

	// currently used to check if player hits treasure!
	public boolean checkHit(Player pl, Treasure t) {

		if (t.getxCoordTrs() == pl.getxCoord() && t.getyCoordTrs() == pl.getyCoord()) {
			return true;
		}

		return false;
	}

	// checks if player hits any monsters
	public boolean checkContact(Player pl, ArrayList<MovingPieces> mp) {

		for (MovingPieces move : mp) {
			
			if (move instanceof Monster && move.getxCoord() == pl.getxCoord() && move.getyCoord() == pl.getyCoord()) {
				return true;
			}
		}
		

		return false;
	}
	
	// move monster -  It can move diagonally 
	public void moveCloser(MovingPieces movingPieces){
		
		
		if (pl.getxCoord() > movingPieces.getxCoord()){
			movingPieces.move(Direction.EAST);
		} else if (pl.getxCoord() < movingPieces.getxCoord()){
			movingPieces.move(Direction.WEST);
		}
		
		if (pl.getyCoord() > movingPieces.getyCoord()){
			movingPieces.move(Direction.NORTH);
		} else if (pl.getyCoord() < movingPieces.getyCoord()){
			movingPieces.move(Direction.SOUTH);
		}
		
	}
	
	// Shows coord of all pieces on game map
	public void cheats(){
		System.out.println("CHEAT: TREASURE POSITION: " + treasureList.get(0).getxCoordTrs() + " "
				+ treasureList.get(0).getyCoordTrs());
		System.out.println("CHEAT: MONSTER POSITION: " + monsterList.get(0).getxCoord() + " "
						+ monsterList.get(0).getyCoord());
		System.out.println(("DEBUG: YOUR CURRENT POSITION " + pl.getxCoord() + ", " + pl.getyCoord()));
	}

}
