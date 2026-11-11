package elise;

public class RatFactory {
    public static RatEnemys createRat (int roomNumber) {
        // En switch expression används för att returnera rätt råtta
        // direkt från switchen, utan att behöva skriva return i varje case.
        return switch (roomNumber) {
          case 1, 2 -> new SewerRat();
          case 3, 4 -> new PlagueRat();
          case 5 -> new KingRat();
          default -> throw new IllegalArgumentException("Invalid room number");
        };
    }
}
