/**
 * @author Corey Beaver
 * Util.java
 * 
 * Contains utility methods for the Battleship game.
 */
public class Util {

    /**
     * Clears the console screen on Windows, macOS, and Linux.
     */
    public static void clearConsole() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("windows")) {
                // Use the Windows 'cls' command
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            } else {
                // Use the Unix 'clear' command (macOS/Linux)
                new ProcessBuilder("clear")
                        .inheritIO()
                        .start()
                        .waitFor();
            }
        } catch (Exception e) {
            // Fallback: print several newlines if the command fails
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
}
