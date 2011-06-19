
public class Game {

	/**
	 * Test class
	 * 
	 * @author Jackie
	 */
	public static void main(String[] args) {
		

		GameSpace gs = new GameSpace(10,10);
		
		Disk d = gs.addDisk(new Point (0,0));
		
		gs.addSquare(2);
		gs.addSquare(3);
		
		gs.addJewel(7);
		
		if(d.throwDisk(3, 6, 3)){
			System.out.println("GAME WON");
		}

	}

}
