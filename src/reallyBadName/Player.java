package reallyBadName;

public class Player extends MovingPieces{

		private String name;
		//private int xCoordPlyr;
		//private int yCoordPlyr;
		
		
//		public Player(String name, int xCoordPlyr, int yCoordPlyr) {
//			super();
//			this.name = name;
//			super.xCoordPlyr = xCoordPlyr;
//			//this.yCoordPlyr = yCoordPlyr;
//		}

		public Player(String name, int xCoordPlyr, int yCoordPlyr) {
			super(xCoordPlyr, yCoordPlyr);
		}



		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
			

}
