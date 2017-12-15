package reallyBadName;

import java.util.ArrayList;
import java.util.Scanner;

public class TheGame {

	Player pl;

	ArrayList<Treasure> treasureList = new ArrayList<>();

	public void startGame() {

		String intro = "You awaken to find yourself in a barren moor, Whats your name?";
		System.out.println(intro);
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		//sc.close();
		createPlayer(name);

		String init = "Try North, East, South or West to find the treasure!";
		System.out.println(init);

		boolean inputCorrect = false;
		boolean collectedTreasure = false;
		String userInput;
		
		do {

			try {
				Scanner sc1 = new Scanner(System.in);
				userInput = sc1.nextLine().toLowerCase();
				sc1.reset();

				System.out.println("Cheat " + treasureList.get(0).getxCoordTrs() + " " + treasureList.get(0).getyCoordTrs());
				
				switch (userInput) {
				case "north":
					pl.move(Direction.NORTH);
					inputCorrect = true;
					break;
				case "east":
					pl.move(Direction.EAST);
					inputCorrect = true;
					break;
				case "south":
					pl.move(Direction.SOUTH);
					inputCorrect = true;
					break;
				case "west":
					pl.move(Direction.WEST);
					inputCorrect = true;
					break;
				default:
					System.out.println("WTH, you cant go there");
					inputCorrect = false;
					break;
				}
				
				collectedTreasure = checkHit(pl, treasureList.get(0));
				System.out.println("The dial reads: " + calculateDistance(pl, treasureList.get(0)));

			} catch (Exception e) {
				// chastise the user
				System.out.println("lol fail");
			}
			
		} while (!inputCorrect || !collectedTreasure); // TODO

		System.out.println("You win!");
	}

	public void createPlayer(String name) {

		System.out.println("Hi " + name + ", You are at: " + 0 + ", " + 0);
		pl = new Player(name, 0, 0);
		
		CreateTreasure();
	}

	public void CreateTreasure() {
		final int UPPER = 5;
		final int LOWER = -5;

		int x = (int) (Math.random() * (UPPER - LOWER) + LOWER);
		int y = (int) (Math.random() * (UPPER - LOWER) + LOWER);

		Treasure t = new Treasure(x, y);
		treasureList.add(t);

	}
	

	public double calculateDistance(Player pl, Treasure t) {
		 double distance = Math.hypot(t.getxCoordTrs() - pl.getxCoordPlyr(), t.getyCoordTrs() - pl.getyCoordPlyr());
		 return distance;
	}
	
	public boolean checkHit(Player pl, Treasure t){

		if (t.getxCoordTrs() == pl.getxCoordPlyr() && t.getyCoordTrs() == pl.getyCoordPlyr()){
			return true;	
		}
			
		return false;
	}

}
