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

            IO.println("Your HP: " + hero.getHealth() + "\tEnemy HP: " + enemy.getHealth());
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
                        hero.restoreHealth;
                    } else {
                        IO.println("Invalid input!");
                        continue;
                    }
                }
                default -> {
                    IO.println("Invalid choice.");
                    continue;
                }

                //Varje handling ska följas av fiendens handling.

            }

            //Belöning ska delas ut om spelaren vinner.

        }

    }
}
