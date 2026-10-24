package elise;

public class PlagueRat implements RatEnemys {

    private int health = 50;

    /**
     * Metoden tar emot en int parameter på skadan som gjorts
     * och minskar objektets hälsa med den summan.
     * @param damage
     */
    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    /**
     * Metoden returnerar true om objektets hälsa är större än 0,
     * och returnerar false om objektets hälsa är mindre än 0, alltså död.
     * @return
     */
    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
