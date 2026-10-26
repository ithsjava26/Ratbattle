package elise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EliseTest {

    @Test
    public void shouldReturnTrue() {

        // Arrange
        RatEnemys sewerRat = new SewerRat();
        // Act
        sewerRat.takeDamage(29);
        // Assert
        assertTrue(sewerRat.isAlive());
    }

    @Test
    public void shouldReturnFalse() {
        RatEnemys sewerRat = new SewerRat();
        sewerRat.takeDamage(31);
        assertFalse(sewerRat.isAlive());

    }

    @Test
    public void shouldReturnCurrentHealth() {
        SewerRat sewerRat = new SewerRat();
        sewerRat.takeDamage(29);
        assertEquals(1, sewerRat.getHealth());
    }
}
