
package RattWorld;

import java.util.Scanner;

public class GameMenu {

    private Scanner scanner;
    private GameEngine game;

    public GameMenu() {
        scanner = new Scanner(System.in);
        game = new GameEngine();
    }

    public void showMenu() {

        boolean menuRunning = true;

        while (menuRunning) {

            System.out.println("====================");
            System.out.println("    RAT BATTLE");
            System.out.println("====================");

            System.out.println("1. Start new adventure");
            System.out.println("2. Continue saved game");
            System.out.println("3. Show hero equipment");
            System.out.println("4. Fight next enemy");
            System.out.println("e. Exit");

            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {

                case "1":
                    game.startGame();
                    break;

                case "2":
                    System.out.println("Continue saved game");
                    break;

                case "3":
                    System.out.println("Show hero equipment");
                    break;

                case "4":
                    System.out.println("Fight next enemy");
                    break;

                case "e":
                    game.endGame();
                    menuRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
