package RattWorld;

public class GameEngine {

    // Variables
    private boolean gameRunning;
    private int currentRoom;

    // Constructor
    public GameEngine() {
        this.gameRunning = false;
        this.currentRoom = 1;
    }

    // Start the game
    public void startGame() {
        gameRunning = true;
        System.out.println("Welcome to RattBattle!");
        System.out.println("You are now in room " + currentRoom);
    }

    // End the game
    public void endGame() {
        gameRunning = false;
        System.out.println("Game Over!");
    }

    // Check if the game is running
    public boolean isGameRunning() {
        return gameRunning;
    }

    // Get current room
    public int getCurrentRoom() {
        return currentRoom;
    }

    // Move to the next room
    public void nextRoom() {
        if (gameRunning) {
            currentRoom++;
            System.out.println("You moved to room " + currentRoom);
        } else {
            System.out.println("Start the game first!");
        }
    }
}