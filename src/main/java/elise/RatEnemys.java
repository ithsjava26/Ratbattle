package elise;

public interface RatEnemys {

    //abstrakt metod (måste implementeras)
    void takeDamage(int damage);

    //abstrakt metod (måste implementeras)
    boolean isAlive();

    //abstrakt metod (måste implementeras)
    int attack();

    //abstrakt metod (måste implementeras)
    Reward getReward();
}
