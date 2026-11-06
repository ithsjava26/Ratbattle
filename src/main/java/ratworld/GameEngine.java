
package ratworld;

import battle.Battle;
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
    private Battle battle;

    public GameEngine() {

        gameRunning = false;
        currentRoom = 1;

        hero = new Hero();
        battle = new Battle();

        rooms = new Room[5];

        rooms[0] = new Room(
                1,
                "Dark Sewer",
                "A dark and dirty sewer.",
                new SewerRat()
        );

        rooms[1] = new Room(
                2,
                "Old Tunnel",
                "An old tunnel filled with strange sounds.",
                new SewerRat()
        );

        rooms[2] = new Room(
                3,
                "Rat Nest",
                "A dangerous place full of plague rats.",
                new PlagueRat()
        );

        rooms[3] = new Room(
                4,
                "Underground Lake",
                "A mysterious lake beneath the city.",
                new PlagueRat()
        );

        rooms[4] = new Room(
                5,
                "Rat King's Lair",
                "The home of the dangerous Rat King.",
                new KingRat()
        );
    }

    // Start the game
    public void startGame() {

        gameRunning = true;
        currentRoom = 1;

        System.out.println("\nWelcome to RatBattle!");
        showCurrentRoom();
    }

    // End the game
    public void endGame() {

        gameRunning = false;
        System.out.println("Game Over!");
    }

    // Check if game is running
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

    // Get current room object
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
            System.out.println("Please start the game first.");
            return;
        }

        getRoom().displayRoom();

        System.out.println(
                "Enemy: " + getCurrentEnemy().getClass().getSimpleName()
        );
    }

    // Check if hero is alive
    public boolean isHeroAlive() {
        return hero.isAlive();
    }

    // Start battle with current enemy
    public void fightCurrentEnemy() {

        if (!gameRunning) {
            System.out.println("Please start the game first.");
            return;
        }

        if (!hero.isAlive()) {
            System.out.println("Your hero is dead!");
            endGame();
            return;
        }

        RatEnemys enemy = getCurrentEnemy();

        if (!enemy.isAlive()) {
            System.out.println("You already defeated this enemy!");
            return;
        }

        System.out.println("\nA battle begins!");

        battle.battleSystem(hero, enemy);

        if (!hero.isAlive()) {
            System.out.println("\nYou have been defeated!");
            endGame();
        } else if (!enemy.isAlive()) {
            System.out.println("\nYou defeated the enemy!");
        }
    }

    // Move to next room
    public void nextRoom() {

        if (!gameRunning) {
            System.out.println("Please start the game first.");
            return;
        }

        if (!hero.isAlive()) {
            System.out.println("You cannot continue. Your hero is dead.");
            endGame();
            return;
        }

        if (getCurrentEnemy().isAlive()) {
            System.out.println("You must defeat the enemy before moving!");
            return;
        }

        if (currentRoom < rooms.length) {

            currentRoom++;

            System.out.println("\nMoving to the next room...");
            showCurrentRoom();

        } else {

            System.out.println("\nCongratulations!");
            System.out.println("You completed RatBattle!");

            endGame();
        }
    }
}
