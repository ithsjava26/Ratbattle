
package elise;

import inventory.Inventory;
import weapons.Attackable;
import weapons.MeleeWeapon;

public class Hero {

    private int health;
    private Attackable weapon;
    private Inventory inventory;

    public Hero() {
        this.health = 100;
        this.weapon = new MeleeWeapon("Knife", 10);
        this.inventory = new Inventory();
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        if (damage > 0) {
            health -= damage;

            if (health < 0) {
                health = 0;
            }
        }
    }

    public int attack() {
        return weapon.causeDamage();
    }
}
