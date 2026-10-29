package weapons;

public class RangedWeapon extends BaseWeapon {

    private int amunition;

    public RangedWeapon(String name, int attackDamage, int amunition) {
        super(name, attackDamage);
        this.amunition = amunition;
    }

    @Override
    public int causeDamage() {

        if (amunition > 0) {
            amunition -= 1;
            return super.causeDamage();
        }
        IO.println("KLICK! Out of amunition!");
        return 0;
    }
}
