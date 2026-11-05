
package RattWorld;

import java.util.Scanner;

public class GameMenu {

    private Scanner scanner;
    private GameEngine game;

    // Constructor
    public GameMenu() {

        scanner = new Scanner(System.in);
        game = new GameEngine();
    }

    // Show menu
    public void showMenu() {

        boolean menuRunning = true;

        while (menuRunning) {

            System.out.println("======================");
            System.out.println("      RAT BATTLE");
            System.out.println("======================");

            System.out.println("1. Start new adventure");
            System.out.println("2. Show current room");
            System.out.println("3. Show hero health");
            System.out.println("4. Fight enemy");
            System.out.println("5. Go to next room");
            System.out.println("e. Exit");

            System.out.print("Choose an option: ");

            String choice = scanner.nextLine()
                    .trim()
                    .toLowerCase();

            switch (choice) {

                case "1":
                    game.startGame();
                    break;

                case "2":
                    game.showCurrentRoom();
                    break;

                case "3":
                    System.out.println(
                            "Hero health: "
                                    + game.getHero().getHealth()
                    );
                    break;

                case "4":
                    System.out.println(
                            "Battle system is not ready yet."
                    );
                    break;

                case "5":
                    game.nextRoom();
                    break;

                case "e":
                    game.endGame();
                    menuRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}
