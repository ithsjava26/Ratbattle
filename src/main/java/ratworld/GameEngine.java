
package ratworld;

import battle.Battle;
import elise.Hero;
import elise.RatEnemys;
import elise.RatFactory;
// Lägger till importerna som behövs till denna klass för Observer-mönstret
import observer.RoomObserver;
import observer.RoomMessageObserver;
import observer.RoomVisitObserver;
import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    private boolean gameRunning;
    private int currentRoom;
    private Room[] rooms;
    private Hero hero;
    private Battle battle;
    private SaveGame saveGame;
    // Lägger till ett fält som skall lagra observatörer i en ArrayList med typen av interfacet RoomObserver
    private List<RoomObserver> observers = new ArrayList<>();

    public GameEngine() {

        gameRunning = false;
        currentRoom = 1;

        hero = new Hero();
        battle = new Battle();

        rooms = new Room[5];

        saveGame = new SaveGame();

        // Skapar observerklass-objekt och lägger till i listan
        observers.add(new RoomMessageObserver());
        observers.add(new RoomVisitObserver());

        rooms[0] = new Room(
                1,
                "Dark Sewer",
                "A dark and dirty sewer.",
                RatFactory.createRat(1)
        );

        rooms[1] = new Room(
                2,
                "Old Tunnel",
                "An old tunnel filled with strange sounds.",
                RatFactory.createRat(2)
        );

        rooms[2] = new Room(
                3,
                "Rat Nest",
                "A dangerous place full of plague rats.",
                RatFactory.createRat(3)
        );

        rooms[3] = new Room(
                4,
                "Underground Lake",
                "A mysterious lake beneath the city.",
                RatFactory.createRat(4)
        );

        rooms[4] = new Room(
                5,
                "Rat King's Lair",
                "The home of the dangerous Rat King.",
                RatFactory.createRat(5)
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

            // En loop som går igenom observers-listan och för varje objekt i listan anropas metoden
            // onRoomEntered() på det objektet. Med metodanropet följer currentRoom som talar om för
            // metoden vilket rum spelaren är på.
            for (RoomObserver observer : observers) {
                observer.onRoomEntered(currentRoom);
            }

            System.out.println("\nMoving to the next room...");
            showCurrentRoom();

        } else {

            System.out.println("\nCongratulations!");
            System.out.println("You completed RatBattle!");

            endGame();
        }
    }

    // Save current game progress
    public void saveCurrentGame() {

        int[] enemyHealth = new int[rooms.length];

        for (int i = 0; i < rooms.length; i++) {
            enemyHealth[i] = rooms[i].getEnemy().getHealth();
        }

        saveGame.save(
                currentRoom,
                hero.getHealth(),
                enemyHealth
        );
    }

    // Load saved game progress
    public void loadSavedGame() {

        GameSaveData data = saveGame.load();

        if (data == null) {
            return;
        }

        int savedRoom = data.getCurrentRoom();
        int[] savedEnemyHealth = data.getEnemyHealth();

        if (savedRoom < 1 || savedRoom > rooms.length
                || savedEnemyHealth.length != rooms.length) {
            System.out.println("Invalid save data.");
            return;
        }

        currentRoom = savedRoom;

        for (int i = 0; i < rooms.length; i++) {

            RatEnemys enemy = rooms[i].getEnemy();

            int damage = enemy.getMaxHealth() - savedEnemyHealth[i];

            if (damage > 0) {
                enemy.takeDamage(damage);
            }
        }

        // Add hero.setHealth(data.getHeroHealth())
        // after your teammate adds setHealth() to Hero.java.

        gameRunning = true;

        System.out.println("Game restored successfully!");
        showCurrentRoom();
    }

}
