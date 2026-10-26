package elise;

public class SewerRat implements RatEnemys {

    private int health = 30;

    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
