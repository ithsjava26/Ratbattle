package weapons;

abstract class BaseWeapon implements Attackable {

    private final String name;
    private final int baseDamage;

    BaseWeapon(String name, int baseDamage) {
        this.name = name;
        this.baseDamage = baseDamage;
    }


    @Override
    public int causeDamage() {
        int attackChance = (int) ((Math.random() * 100) + 1);

        if (attackChance <= 90)
            return baseDamage;
        else if (attackChance <= 95)
            return baseDamage * 2;
        else
            return 0;
    }

}
