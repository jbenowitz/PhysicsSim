
public class Jewel implements GamePiece{

	/**
	 * Length of one side of the square
	 */
	public static int LENGTH = 3;

	public int min_x;
	public int max_x;
	public int min_y;
	public int max_y;
	
	public Point pt_lb; 
	public Point pt_rb; 
	public Point pt_lt; 
	public Point pt_rt;
	
	private GameSpace gs;
	
	
	/**
	 * Constructor.  Given left most x value
	 * 
	 * @param l = left x
	 */
	public Jewel(int l, GameSpace gs){
		
		this.min_x = l;
		this.max_x = l + LENGTH;
		
		this.min_y = findMinY(); 
		this.max_y = min_y + LENGTH;
		
		this.pt_lb = new Point(min_x, min_y);
		this.pt_rb = new Point(max_x, min_y);
		this.pt_lt = new Point(min_x, max_y);
		this.pt_rt = new Point(max_x, max_y);
		
		this.gs = gs;
		
	}
	
	
	/**
	 * Checks to see if Point p is within this Jewel
	 * 
	 * @param Point p, see if that point is within the jewel
	 */
	@Override
	public boolean isPointIn(Point p) {
		
		if((min_x <= p.x) && (max_x >= p.x) && (min_y <= p.y) && (max_y >= p.y)){
			return true;
		}
		else{
			return false;
		}
		
	}

	
	/**
	 * Checks to see if any extreme points is within the given game piece.
	 * If so, then this Jewel is touching.  If it is a disk, it will take care of seeing gameend
	 * 
	 * @param GamePiece gp, a given game piece to compare. 
	 * 
	 */
	@Override
	public boolean isTouching(GamePiece gp) {
		if(gp.isPointIn(pt_lb) || gp.isPointIn(pt_lt) || 
				gp.isPointIn(pt_rb) || gp.isPointIn(pt_rt)){
			return true;
		}
		else{
			return false;
		}
	}

	
	/**
	 * Game piece slowly drops in game space.  Keeps checking to see if it is touching
	 * another piece.  If so, it stops, otherwise keeps going.
	 * 
	 * 
	 * @return minimum Y (stopping point)
	 */
	public int findMinY(){
		int dropY = gs.height;
		
		while(dropY!=0){
			for(GamePiece piece : gs.pieces){
				if(isTouching(piece)){
					return dropY+1;
				}
			}
			dropY--;
			if(dropY == 0){
				return dropY;
			}
		}
		
		return dropY;
	}


}
