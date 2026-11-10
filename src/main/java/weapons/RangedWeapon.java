package weapons;

public class RangedWeapon extends BaseWeapon {

    private int ammunition;

    public RangedWeapon(String name, int attackDamage, int amunition) {
        super(name, attackDamage);
        this.ammunition = amunition;
    }

    @Override
    public int causeDamage() {

        if (ammunition > 0) {
            ammunition -= 1;
            return super.causeDamage();
        }
        IO.println("KLICK! Out of amunition!");
        return 0;
    }

    public int addAmmo(int amount) {
        return ammunition += amount;
    }

    public int getAmmunition() {
        return ammunition;
    }
}
