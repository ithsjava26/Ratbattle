package battle;

import elise.Hero;
import elise.RatEnemys;


public class Battle {

    public void battleSystem(Hero hero, RatEnemys enemy) {

        int damage = 0;
        String inputChoice;
        String battleMenu = """
                
                Battle choices
                ================
                1. Melee attack
                2. Range attack
                3. Use item
                ================
                \n""";

        //While behöver att hero.isAlive finns.
        while (hero.isAlive() && enemy.isAlive()) {

            displayHp(hero, enemy);
            IO.println("================================");

            IO.println(battleMenu);
            inputChoice = IO.readln("Choose action: ");

            switch (inputChoice) {
                case "1" -> {
                    //Anrop för hjältens attack med melee-vapen, behöver koppla till causeDamage i BaseWeapon.
                    damage = hero.attackMelee();
                    enemy.takeDamage(damage);
                    IO.println("Enemy takes " + damage + " damage!");
                }
                case "2" -> {
                    //Anrop för hjältens attack med range-vapen, behöver koppla till causeDamage i BaseWeapon.
                    //Nedräkning av ammunition sköts automatiskt.
                    damage = hero.attackRange();
                    enemy.takeDamage(damage);
                    IO.println("Enemy takes " + damage + " damage!");
                }
                case "3" -> {
                    //Använda föremål (Potion)
                    if (!hero.printInventory())
                        continue;

                    inputChoice = IO.readln("Do you want to use a potion? y/n: ");
                    if (inputChoice.equalsIgnoreCase("n"))
                        continue;
                    else if (inputChoice.equalsIgnoreCase("y")) {
                        //Todo: Lägg till restoreHealth i Hero-klassen.
                        //hero.restoreHealth;
                    } else {
                        IO.println("Invalid input!");
                        continue;
                    }
                }
                default -> {
                    IO.println("Invalid choice.");
                    continue;
                }
            }
            if (!enemy.isAlive())
                continue;

            IO.println("Enemy attacks!");
            damage = enemy.attack();
            hero.takeDamage(damage);

        }
        //Belöning ska delas ut om spelaren vinner.
        if (hero.isAlive()) {
            IO.println("You defeated the enemy!");
            receiveReward(hero, enemy);
        }


    }
    private void displayHp(Hero hero, RatEnemys enemy) {
        int heroHealth = hero.getHealth();
        int enemyHealth = enemy.getHealth();

        int heroHpPercent = (heroHealth * 100) / hero.getMaxHealth();
        int enemyHpPercent = (enemyHealth * 100) / enemy.getMaxHealth();

        HpColor heroTextColor = HpColor.fromPercentage(heroHpPercent);
        HpColor enemyTextColor = HpColor.fromPercentage(enemyHpPercent);


        IO.println("Your HP: " + heroTextColor + heroHealth + "/" + hero.getMaxHealth() + HpColor.RESET
                + "\t\t\t" + enemy.getName() + " HP: " + enemyTextColor
                + enemyHealth + "/" + enemy.getMaxHealth() + HpColor.RESET);
        IO.println(heroTextColor + createHpBar(heroHpPercent) + HpColor.RESET + "\t"
                + enemyTextColor + createHpBar(enemyHpPercent) + HpColor.RESET);
    }

    private String createHpBar(int percent) {
        int totalBlocks = 15;
        int filledBlocks = (percent * totalBlocks) / 100;
        int emptyBlocks = totalBlocks - filledBlocks;

        return "[" + "▮".repeat(filledBlocks) + "▯".repeat(emptyBlocks) + "]";
    }

    private void receiveReward(Hero hero, RatEnemys enemy) {

        switch (enemy.getReward()) {
            case POTION -> hero.addPotion();
            case AMMO -> hero.addAmmo(3);
        }

    }

}