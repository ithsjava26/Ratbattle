package battle;

import elise.Hero;
import elise.RatEnemys;

public class Battle {

    public void battleSystem(Hero hero, RatEnemys enemy) {

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

            IO.println(battleMenu);
            inputChoice = IO.readln("Choose action: ");

            switch (inputChoice) {
                case "1" -> {
                    //Anrop för hjältens attack med melee-vapen, behöver koppla till causeDamage i BaseWeapon.
                }
                case "2" -> {
                    //Anrop för hjältens attack med range-vapen, behöver koppla till causeDamage i BaseWeapon
                    //samt räkna ner amunition i RangeWeapon-objektet.
                }
                case "3" -> {
                    //Använda föremål (Potion)
                }
            }

            //Varje handling ska följas av fiendens handling.

        }


    }

}
