
package elise;

import inventory.Inventory;
import weapons.Attackable;
import weapons.MeleeWeapon;
import weapons.RangedWeapon;

public class Hero {

    private int health;
    private Attackable meleeWeapon;
    private RangedWeapon rangedWeapon;
    private Inventory inventory;

    public Hero() {
        this.health = 100;
        this.meleeWeapon = new MeleeWeapon("Knife", 10);
        this.rangedWeapon = new RangedWeapon("Pistol", 20, 6);
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

    public int attackMelee() {
        return meleeWeapon.causeDamage();
    }

    public int attackRange() {
        return rangedWeapon.causeDamage();
    }

    public boolean printInventory() {
        return inventory.printInventory();
    }
}
