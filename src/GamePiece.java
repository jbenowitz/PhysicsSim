
/**
 * Interface used by both a Square (indirectly a Jewel) and a Disk
 * 
 * @author Jackie
 *
 */
public interface GamePiece {
	
	public boolean isPointIn(Point p);
	
	public boolean isTouching(GamePiece gp);
	
}
