
package ratworld;

import java.util.Scanner;

public class GameMenu {

    private GameEngine game;
    private Scanner scanner;

    public GameMenu() {

        game = new GameEngine();
        scanner = new Scanner(System.in);
    }

    // Display the game menu
    public void showMenu() {

        boolean running = true;

        while (running) {

            System.out.println("\n===== RATBATTLE =====");
            System.out.println("1. Start Game");
            System.out.println("2. Show Current Room");
            System.out.println("3. Show Hero Health");
            System.out.println("4. Fight Enemy");
            System.out.println("5. Next Room");
            System.out.println("E. Exit Game");

            System.out.print("\nChoose an option: ");

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

                    System.out.println("\nHero Health: "
                            + game.getHero().getHealth()
                            + "/"
                            + game.getHero().getMaxHealth());

                    break;

                case "4":

                    game.fightCurrentEnemy();
                    break;

                case "5":

                    game.nextRoom();
                    break;

                case "e":

                    game.endGame();
                    running = false;

                    System.out.println("Thanks for playing RatBattle!");
                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
