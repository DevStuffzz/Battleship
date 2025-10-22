/**
 * @author Corey Beaver
 * Board.java
 * 
 * Represents an 8x8 Battleship board made up of Tile objects.
 */
public class Board {

    private static final int SIZE = 8;
    private Tile[][] grid;

    public Board() {
        grid = new Tile[SIZE][SIZE];
        initializeBoard();
    }

    /**
     * Initializes the board with empty tiles.
     */
    private void initializeBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = new Tile(col + 1, (char) ('A' + row));
            }
        }
    }

    /**
     * Gets a specific tile on the board by coordinate.
     *
     * @param x Column (1–8)
     * @param y Row ('A'–'H')
     * @return The corresponding Tile
     */
    public Tile getTile(int x, char y) {
        int row = Character.toUpperCase(y) - 'A';
        int col = x - 1;

        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE) {
            return grid[row][col];
        } else {
            throw new IllegalArgumentException("Invalid tile coordinates: " + y + x);
        }
    }

    /**
     * Places a ship or mark on the given tile.
     */
    public void occupyTile(int x, char y, Tile.TileState state) {
        Tile tile = getTile(x, y);
        tile.Enhabit(state);
    }

    /**
     * Prints the current board state to the console.
     */
    public void display() {
        System.out.print("   ");
        for (int x = 1; x <= SIZE; x++) {
            System.out.print(x + " ");
        }
        System.out.println();

        for (int row = 0; row < SIZE; row++) {
            char rowLabel = (char) ('A' + row);
            System.out.print(rowLabel + "  ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(grid[row][col].toString() + " ");
            }
            System.out.println();
        }
    }

    /**
     * Resets the board to all empty tiles.
     */
    public void reset() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col].setState(Tile.TileState.EMPTY);
            }
        }
    }
}
