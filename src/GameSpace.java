import java.util.ArrayList;


/**
 * GameSpace creates the map of the space.
 * Constructor initializes the width and height of the gameboard.
 * 
 * @author Jackie
 *
 */
public class GameSpace {

	public int width;
	public int height;
	public int[][] board;
	
	//array of gampieces
	public ArrayList<GamePiece> pieces;
	
	
	/**
	 * Sets width and height of gamespace
	 * Initializes the gameboard 2d array.
	 * 
	 * @param width
	 * @param height
	 */
	public GameSpace(int width, int height){
		
		this.width = width;
		this.height = height;
		
		board = new int[width][height];
		
	}
	
	
	/**
	 * Adds a square, dropped in with a leftx coordinate
	 * stops when either hits the ground or another gamepiece.
	 * 
	 * @param leftx
	 */
	public void addSquare(int leftx){
		pieces.add(new Square(leftx, this));
		
	}
	
	
	/**
	 * Adds a disk at the given starting point
	 * 
	 * @param p = starting point
	 */
	public Disk addDisk(Point p){
		
		Disk td = new Disk(p,this);
		return td;
		
	}
	
	
	/**
	 * Adds a jewel, drops in with a leftx coordinate.
	 * Stops when either hitting the ground or another game piece.
	 * 
	 * @param leftx
	 */
	public void addJewel(int leftx){
		pieces.add(new Jewel(leftx, this));
	}
}
