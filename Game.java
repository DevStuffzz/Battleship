/**
 * @author Corey Beaver
 * Game.java 
 * 
 * Contains all main game logic and loop.
 */
import java.util.Scanner;

public class Game implements Runnable {

    private Board userBoard;
    private Board enemyBoard;
    private boolean running;
    private Scanner scanner;

    public Game() {
        userBoard = new Board();
        enemyBoard = new Board();
        scanner = new Scanner(System.in);
        running = true;
    }

    @Override
    public void run() {
        System.out.println("=== Welcome to Battleship ===\n");
        setup();
        mainLoop();
        System.out.println("Game over!");
    }

    /**
     * Initializes player and enemy boards.
     */
    private void setup() {
        System.out.println("Setting up your board...\n");
        userBoard.display();

        // Example manual placement (you could randomize or expand later)
        userBoard.occupyTile(2, 'B', Tile.TileState.USER);
        userBoard.occupyTile(3, 'B', Tile.TileState.USER);
        userBoard.occupyTile(4, 'B', Tile.TileState.USER);

        enemyBoard.occupyTile(5, 'E', Tile.TileState.ENEMY);
        enemyBoard.occupyTile(6, 'E', Tile.TileState.ENEMY);
        enemyBoard.occupyTile(7, 'E', Tile.TileState.ENEMY);

        System.out.println("Your ships have been placed!\n");
    }

    /**
     * Main game loop – alternates turns until one side is defeated.
     */
    private void mainLoop() {
        while (running) {
            Util.clearConsole();

            System.out.println("=== Your Turn ===");
            playerTurn();

            if (hasPlayerWon()) {
                System.out.println("\nYou destroyed all enemy ships! You win!");
                break;
            }

            System.out.println("\n=== Enemy's Turn ===");
            enemyTurn();

            if (hasEnemyWon()) {
                System.out.println("\nAll your ships have been destroyed. You lose!");
                break;
            }

            System.out.print("\nPress Enter to continue...");
            scanner.nextLine();
        }

        System.out.println("\nGame over!");
    }


    /**
     * Handles the player’s turn.
     */
    private void playerTurn() {
        System.out.println("\nYour Board:");
        userBoard.display();

        System.out.println("\nEnemy Board (hidden):");
        enemyBoard.display();

        System.out.print("\nEnter attack coordinates (e.g., E5): ");
        String input = scanner.nextLine().toUpperCase().trim();

        if (input.length() < 2) {
            System.out.println("Invalid input.");
            return;
        }

        char y = input.charAt(0);
        int x = Character.getNumericValue(input.charAt(1));

        try {
            Tile target = enemyBoard.getTile(x, y);
            if (target.getState() == Tile.TileState.ENEMY) {
                System.out.println("Hit!");
                target.setState(Tile.TileState.BOTH);
            } else {
                System.out.println("Miss!");
            }
        } catch (Exception e) {
            System.out.println("Invalid coordinates.");
        }
    }

    /**
     * Very basic enemy AI that attacks random tiles.
     */
    private void enemyTurn() {
        int x = (int) (Math.random() * 8) + 1;
        char y = (char) ('A' + (int) (Math.random() * 8));

        Tile target = userBoard.getTile(x, y);
        if (target.getState() == Tile.TileState.USER) {
            System.out.println("Enemy hit your ship at " + y + x + "!");
            target.setState(Tile.TileState.BOTH);
        } else {
            System.out.println("Enemy missed at " + y + x + ".");
        }
    }
    
    /**
     * Checks if all enemy ships are destroyed.
     */
    private boolean hasPlayerWon() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Tile t = enemyBoard.getTile(col + 1, (char) ('A' + row));
                if (t.getState() == Tile.TileState.ENEMY) {
                    return false; // still at least one enemy ship left
                }
            }
        }
        return true;
    }

    /**
     * Checks if all player ships are destroyed.
     */
    private boolean hasEnemyWon() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Tile t = userBoard.getTile(col + 1, (char) ('A' + row));
                if (t.getState() == Tile.TileState.USER) {
                    return false; // still at least one player ship left
                }
            }
        }
        return true;
    }

}
