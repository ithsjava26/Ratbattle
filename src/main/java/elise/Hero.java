
package elise;

import inventory.Inventory;
import weapons.Attackable;
import weapons.MeleeWeapon;
import weapons.RangedWeapon;

public class Hero {

    private int maxHealth;
    private int health;
    private Attackable meleeWeapon;
    private RangedWeapon rangedWeapon;
    private Inventory inventory;

    public Hero() {
        this.maxHealth = 100;
        this.health = 100;
        this.meleeWeapon = new MeleeWeapon("Knife", 10);
        this.rangedWeapon = new RangedWeapon("Pistol", 20, 6);
        this.inventory = new Inventory();
    }

    public int getHealth() {
        return health;
    }

    //Björn har lagt till maxHealth med getter för att fortsätta bygga Battle
    public int getMaxHealth() {
        return maxHealth;
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
