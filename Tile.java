
/**
 * @author Corey Beaver
 * Tile.java
 * 
 * Relates to the specific section on an 8x8 Board
 */
public class Tile {
	
	private int x;
	private char y;
	
	private TileState state;
	
	public Tile() {
		this(0, 'A');
	}
	

	public Tile(int x, char y) {
		this.x = x; this.y = y;
		this.Enhabit(TileState.EMPTY); // Set to empty by default
	}
	

	/**
	 * Populates the tile
	 * @param state
	 */
	public void Enhabit(TileState state) {
		this.state = state;
	}
	
	
	// -----------  Getters
	public int getX() {
	    return x;
	}

	public char getY() {
	    return y;
	}

	// -----------  Setters

	public TileState getState() {
	    return state;
	}

	public void setState(TileState state) {
	    this.state = state;
	}
	
    @Override
    public String toString() {
        switch (state) {
            case EMPTY: return "~";
            case USER: return "U";
            case ENEMY: return "E";
            case BOTH: return "X";
            default: return "?";
        }
    }


	
	/**
	 * @author Corey Beaver
	 * 
	 * Tile State refers to the current usage of the tile, if
	 * it is inhabited or not
	 * 
	 * EMPTY - No Ship
	 * USER - User Ship
	 * ENEMY - Enemy Ship
	 * BOTH - Both, in the case that both users place ships on the same tile
	 */
	public enum TileState {
	    EMPTY, USER, ENEMY, BOTH
	}

	

}
