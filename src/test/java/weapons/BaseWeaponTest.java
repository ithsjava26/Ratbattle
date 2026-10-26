package weapons;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseWeaponTest {

    @Test
    @DisplayName("calculateDamage should return baseDamage if attackChance is 1 - 90")
    void calculateDamageShouldReturnBaseDamageIfChanceIs1to90() {
        int chance = 50;
        int attackDamage = 10;
        MeleeWeapon testWeapon = new MeleeWeapon("Kniv", attackDamage);

        int result = testWeapon.calculateDamage(chance);
        assertEquals(10, result);

    }

    @Test
    @DisplayName("When attackChance is 90 - 95 it should return double damage")
    void calculateDamageShouldReturnBaseDamageIfChanceIs90To95() {
        int chance = 93;
        int attackDamage = 10;
        MeleeWeapon testWeapon = new MeleeWeapon("Kniv", attackDamage);

        int result = testWeapon.calculateDamage(chance);
        assertEquals(20, result);
    }

    @Test
    @DisplayName("If chance is 95 - 100 calculateDamage should return 0")
    void calculateDamageShouldReturn0IfChanceIs95To100() {
        int chance = 97;
        int attackDamage = 10;
        MeleeWeapon testWeapon = new MeleeWeapon("Kniv", attackDamage);

        int result = testWeapon.calculateDamage(chance);
        assertEquals(0, result);
    }

}