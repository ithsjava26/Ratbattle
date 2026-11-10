
package elise;

import inventory.Inventory;
import items.Item;
import items.Potion;
import weapons.Attackable;
import weapons.MeleeWeapon;
import weapons.RangedWeapon;

import java.util.List;

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

        //Add start potions
        for (int i = 0; i < 3; i++) {
            addPotion();
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else if (health > maxHealth) {
            this.health = maxHealth;
        } else {
            this.health = health;
        }
    }

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

    /**
     * Metoden ökar hjältens HP när hjälten dricker en hälsodryck.
     * @return
     */
    public void restoreHealth(int amount) {
        if (amount > 0) {
            health += amount;
            if (health > maxHealth) {
                health = maxHealth;
            }
        }
    }

    public boolean usePotion() {
        List<Item> itemList = inventory.findItem();

        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);

            if (item instanceof Potion potion) {
                restoreHealth(potion.getHealAmount());
                inventory.removeItem(item);
                return true;
            }
        }
        return false;
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

    public void addPotion() {
        inventory.addItem(new Potion("Health potion", 50));
    }

    public void addAmmo(int amount) {
        rangedWeapon.addAmmo(amount);
    }

    public int getAmmo() {
        return rangedWeapon.getAmmunition();
    }
}
