package elise;

public class KingRat implements RatEnemys {
    // KingRat -> KungRåtta (nivå tre på råtta)

    private int health = 100;

    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public int attack() {
        return 10;
    }
}
