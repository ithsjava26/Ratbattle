
package ratworld;

import elise.Hero;
import elise.SewerRat;

public class RatWorldTest {

    public static void main(String[] args) {

        System.out.println("=== RattWorld Tests ===");

        testRoom();
        testGameEngine();
        testHeroConnection();

        System.out.println("=== Tests Finished ===");
    }

    // Test Room
    public static void testRoom() {

        Room room = new Room(
                1,
                "Dark Sewer",
                "A dark underground room.",
                new SewerRat()
        );

        check(
                room.getEnemy() instanceof SewerRat,
                "Room is connected to SewerRat"
        );
    }

    // Test GameEngine
    public static void testGameEngine() {

        GameEngine game = new GameEngine();

        check(
                game.getCurrentRoom() == 1,
                "Game starts at room 1"
        );

        game.startGame();

        check(
                game.isGameRunning(),
                "Game starts successfully"
        );

        check(
                game.getCurrentEnemy() instanceof SewerRat,
                "Room 1 has SewerRat"
        );

        game.nextRoom();

        check(
                game.getCurrentRoom() == 1,
                "Cannot enter next room before defeating enemy"
        );
    }

    // Test Hero connection
    public static void testHeroConnection() {

        GameEngine game = new GameEngine();

        Hero hero = game.getHero();

        check(
                hero != null,
                "GameEngine has a Hero object"
        );

        check(
                hero.getHealth() == 100,
                "Hero starts with 100 HP"
        );
    }

    // Helper method
    private static void check(boolean condition, String testName) {

        if (condition) {
            System.out.println("[PASS] " + testName);
        } else {
            System.out.println("[FAIL] " + testName);
        }
    }
}
