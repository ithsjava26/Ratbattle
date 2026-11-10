
package ratworld;

public class GameSaveData {

    private int currentRoom;
    private int heroHealth;
    private int[] enemyHealth;

    public GameSaveData(int currentRoom, int heroHealth,
                        int[] enemyHealth) {

        this.currentRoom = currentRoom;
        this.heroHealth = heroHealth;
        this.enemyHealth = enemyHealth;
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public int getHeroHealth() {
        return heroHealth;
    }

    public int[] getEnemyHealth() {
        return enemyHealth;
    }
}
