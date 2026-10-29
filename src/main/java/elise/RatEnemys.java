package elise;

public interface RatEnemys {

    //abstrakt metod (måste implementeras)
    void takeDamage(int damage);

    //abstrakt metod (måste implementeras)
    boolean isAlive();

    //abstrakt metod (måste implementeras)
    int attack();

    //Björn lägger till getHealth för att underlätta koden i Battle
    int getHealth();

    //abstrakt metod (måste implementeras)
    Reward getReward();
}
