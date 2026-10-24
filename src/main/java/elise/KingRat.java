package elise;

public class KingRat implements RatEnemys {

    private int health = 100;

    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
