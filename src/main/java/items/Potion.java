package items;

public class Potion implements Item {

    private final String name;
    private final int healAmount;

    public Potion(String name, int healAmount) {
        this.name = name;
        this.healAmount = healAmount;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
