package elise;

import java.util.Random;

public class PlagueRat implements RatEnemys {
    // PlagueRat -> PestRåtta (nivå två på råtta)

    private int health = 50;

    /**
     * Metoden tar emot hur mycket skada råttan får
     * och minskar råttans HP med motsvarande antal.
     * @param damage antal HP som råttan förlorar.
     */
    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    /**
     * Metoden kontrollerar om råttan lever.
     * Returnerar true om råttans HP är större än 0,
     * annars false om råttans HP är 0 eller mindre.
     * @return true om råttan lever, annars false.
     */
    @Override
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Metoden returnerar hur mycket skada råttan
     * gör per bett på hjälten.
     * @return antal HP som råttans bett skadar.
     */
    @Override
    public int attack() {
        return 7;
    }

    @Override
    public int getHealth() {
        return health;
    }

    /**
     * Metoden slumpar fram om hjältens belöning efter att ha dödat
     * råttan skall vara i form av hälsodryck eller skott till pistolen.
     * @return Reward.POTION eller Reward.AMMO beroende på slumpresultatet.
     */
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
