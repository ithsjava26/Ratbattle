package elise;

public class SewerRat implements RatEnemys {
    // SewerRat -> KloakRåtta (nivå ett på råtta)

    private int health = 30;

    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public int attack() {
        return 5;
    }
}
