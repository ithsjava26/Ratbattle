package elise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void restoreHealthShouldNotExceedMaxHealth() {
        // Arrange
        Hero hero = new Hero();

        // Act
        hero.restoreHealth(50);

        // Assert
        assertEquals(100, hero.getHealth());
    }

    @Test
    void restoreHealthShouldIncreaseHealth() {
        Hero hero = new Hero();
        hero.takeDamage(70);

        // Act
        hero.restoreHealth(50);

        // Assert
        assertEquals(80, hero.getHealth());
    }

    @Test
    void restoreHealthShouldNotChangeForNegativeValue() {
        // Arrange
        Hero hero = new Hero();
        hero.takeDamage(50);

        // Act
        hero.restoreHealth(-50);

        // Assert
        assertEquals(50, hero.getHealth());
    }
}