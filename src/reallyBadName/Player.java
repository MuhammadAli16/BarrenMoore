package reallyBadName;

public class Player {

		private String name;
		private int xCoordPlyr;
		private int yCoordPlyr;
		
		
		public Player(String name, int xCoordPlyr, int yCoordPlyr) {
			//super();
			this.name = name;
			this.xCoordPlyr = xCoordPlyr;
			this.yCoordPlyr = yCoordPlyr;
		}
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getxCoordPlyr() {
			return xCoordPlyr;
		}
		public void setxCoordPlyr(int xCoordPlyr) {
			this.xCoordPlyr = xCoordPlyr;
		}
		public int getyCoordPlyr() {
			return yCoordPlyr;
		}
		public void setyCoordPlyr(int yCoordPlyr) {
			this.yCoordPlyr = yCoordPlyr;
		}
		
		public void move(Direction compass){
			
			switch(compass){
			case EAST:
				this.xCoordPlyr++;
				break;
			case NORTH:
				this.yCoordPlyr++;
				break;
			case SOUTH:
				this.yCoordPlyr--;
				break;
			case WEST:
				this.xCoordPlyr--;
				break;
			}
			
			System.out.println("YOUR CURRENT POSITION " + this.xCoordPlyr + ", " + this.yCoordPlyr );
			
			
		}
		
		

}
