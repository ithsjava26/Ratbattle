package elise;

import java.util.Random;

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

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public Reward getReward() {
        // slumpar fram om belöningen är HP eller skott
        // Hero-klassen hanterar vad belöningen är i mängd.
        Random random = new Random();
        int number = random.nextInt(2);

        if (number == 1) {
            return Reward.POTION;
        }
        return Reward.AMMO;
    }
}
