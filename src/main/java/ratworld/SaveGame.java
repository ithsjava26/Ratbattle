
package ratworld;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaveGame {

    private static final String SAVE_FILE = "savegame.txt";

    // Save game data
    public void save(int currentRoom, int heroHealth,
                     int[] enemyHealth) {

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(SAVE_FILE))) {

            writer.println(currentRoom);
            writer.println(heroHealth);

            for (int health : enemyHealth) {
                writer.println(health);
            }

            System.out.println("Game saved successfully!");

        } catch (IOException e) {

            System.out.println("Could not save the game.");
            e.printStackTrace();
        }
    }

    // Load game data
    public GameSaveData load() {

        try (Scanner scanner = new Scanner(new File(SAVE_FILE))) {

            int currentRoom = scanner.nextInt();
            int heroHealth = scanner.nextInt();

            int[] enemyHealth = new int[5];

            for (int i = 0; i < enemyHealth.length; i++) {
                enemyHealth[i] = scanner.nextInt();
            }

            System.out.println("Game loaded successfully!");

            return new GameSaveData(
                    currentRoom,
                    heroHealth,
                    enemyHealth
            );

        } catch (IOException e) {

            System.out.println("Could not load the game.");
            e.printStackTrace();

            return null;
        }
    }

    // Test save and load
    public static void main(String[] args) {

        SaveGame saveGame = new SaveGame();

        int[] enemyHealth = {30, 30, 50, 50, 100};

        saveGame.save(3, 75, enemyHealth);

        GameSaveData data = saveGame.load();

        if (data != null) {

            System.out.println("Room: "
                    + data.getCurrentRoom());

            System.out.println("Hero HP: "
                    + data.getHeroHealth());

            System.out.println("Enemy Health:");

            for (int health : data.getEnemyHealth()) {
                System.out.println(health);
            }
        }
    }
}
