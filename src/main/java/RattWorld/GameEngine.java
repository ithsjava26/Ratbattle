
package RattWorld;

import elise.Hero;
import elise.RatEnemys;
import elise.SewerRat;
import elise.PlagueRat;
import elise.KingRat;

public class GameEngine {

    private boolean gameRunning;
    private int currentRoom;
    private Room[] rooms;
    private Hero hero;

    // Constructor
    public GameEngine() {

        gameRunning = false;
        currentRoom = 1;

        hero = new Hero();

        rooms = new Room[5];

        rooms[0] = new Room(
                1,
                "Dark Sewer",
                "You hear strange sounds in the darkness.",
                new SewerRat()
        );

        rooms[1] = new Room(
                2,
                "Old Tunnel",
                "The tunnel is narrow and dangerous.",
                new SewerRat()
        );

        rooms[2] = new Room(
                3,
                "Rat Nest",
                "Many rats are hiding here.",
                new PlagueRat()
        );

        rooms[3] = new Room(
                4,
                "Underground Lake",
                "A dark lake blocks your way.",
                new PlagueRat()
        );

        rooms[4] = new Room(
                5,
                "Rat King's Lair",
                "The Rat King is waiting for you.",
                new KingRat()
        );
    }

    // Start game
    public void startGame() {

        gameRunning = true;
        currentRoom = 1;

        System.out.println("Welcome to RattBattle!");

        showCurrentRoom();
    }

    // End game
    public void endGame() {

        gameRunning = false;

        System.out.println("Game Over!");
    }

    // Check game status
    public boolean isGameRunning() {
        return gameRunning;
    }

    // Get current room number
    public int getCurrentRoom() {
        return currentRoom;
    }

    // Get hero
    public Hero getHero() {
        return hero;
    }

    // Get current room
    public Room getRoom() {
        return rooms[currentRoom - 1];
    }

    // Get current enemy
    public RatEnemys getCurrentEnemy() {
        return getRoom().getEnemy();
    }

    // Display current room
    public void showCurrentRoom() {

        if (!gameRunning) {
            System.out.println("Start the game first!");
            return;
        }

        getRoom().displayRoom();

        System.out.println("Enemy: "
                + getCurrentEnemy().getClass().getSimpleName());
    }

    // Check hero health
    public boolean isHeroAlive() {
        return hero.isAlive();
    }

    // Move to next room
    public void nextRoom() {

        if (!gameRunning) {
            System.out.println("Start the game first!");
            return;
        }

        if (!hero.isAlive()) {
            System.out.println("Your hero is defeated!");
            endGame();
            return;
        }

        if (currentRoom < rooms.length) {

            currentRoom++;

            System.out.println("You moved to room " + currentRoom);

            showCurrentRoom();

        } else {

            System.out.println("You completed all rooms!");

            endGame();
        }
    }
}
