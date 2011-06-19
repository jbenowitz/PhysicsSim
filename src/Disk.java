/**
 * What one 'throws'
 * Rouned object (circle)
 * 
 * 
 * @author Jackie
 *
 */
public class Disk implements GamePiece{
	
	/**
	 * Radius of Disk given by programmer
	 */
	public static int RADIUS = 1;
	
	public Point center;
	public GameSpace gs;
	
	
	/**
	 * Constructor sets up game space and center of object
	 * 
	 * @param center
	 * @param gs
	 */
	public Disk (Point center, GameSpace gs){
		this.center = new Point(1, 1); //sets it to the throwing point.
		this.gs = gs;
		
		
	}

	
	
	/**
	 * Checks to see if a given point is within this piece.
	 * 
	 * @param Point p 
	 */
	@Override
	public boolean isPointIn(Point p) {
	
		if(Math.pow(p.x - center.x, 2) + Math.pow(p.y - center.y, 2)  <= Math.pow(RADIUS, 2)){
			return true;
		}
		else{
			return false;
		}
	}

	
	/**
	 * Moves along the edges of the disk and check to see if it is in the game piece
	 * Figures out the minimum x value and maximum x value within this circle.  Then parses
	 * through all the x values within the circle.  Figures out coorisponding y values by 
	 * the equation x^2+y^2=r^2.
	 * 
	 * If the game piece is a jewel, ends game. TODO
	 * 
	 * @param GamePiece gp : see if these 2 game pieces are touching.
	 */
	@Override
	public boolean isTouching(GamePiece gp) {
		//Start walking x value to be the minimum value
		int x = center.x - RADIUS;
		int y = 0;
		
		while(x <= center.x + RADIUS){
			//find cooresponding positive y value
			y = (int) Math.sqrt(Math.pow(RADIUS, 2) - Math.pow(x, 2));
			
			if (gp.isPointIn(new Point (x, y))){
				return true;
			}
			
			
			//find cooresponding negative y value
			y = -y;
			
			if (gp.isPointIn(new Point (x, y))){
				return true;
			}
			
			
			//go to next x value
			x++;
		}
		
		return false;
	}
	
	
	
	
	/**
	 * Given dx and dy, along with dt, figures out the ending the disk
	 * 
	 * @return true - if hits a jewel
	 * 		   false - if just stops
	 */
	public boolean throwDisk(int dx, int dy, int dt){
		boolean stillmoving = true;
		
		double v_x0 = dx/dt;
		double v_y0 = dy/dt;
		double g = -9.81;
		int x = center.x;
		int y = center.y;
		
		Point nextP = new Point(x , y);
		
		
		while(stillmoving){
			//find the next x 
			nextP.x = (int) (nextP.x + v_x0);
			//find the next y
			nextP.y = (int) (nextP.y + (.5)*g);
			
			//check to see if touching any other item
			for(GamePiece piece : gs.pieces){
				if(piece.isPointIn(nextP)){
					center = nextP;
					
					if(piece instanceof Jewel){
						return true;
					}
					else return false;
				}
				
			}
			
			if((nextP.x == 0 || nextP.x == gs.width) && nextP.y == 0){
				center = nextP;
				stillmoving = false;
			}
			else {
				//find next velocity
				v_y0 = v_y0 + g;
				
				stillmoving = true;
			}
		}
		
		return false;
	}

}
