package ratworld;

import elise.RatEnemys;

public class Room {

    private int roomNumber;
    private String roomName;
    private String description;
    private RatEnemys enemy;

    public Room(int roomNumber, String roomName,
                String description, RatEnemys enemy) {

        this.roomNumber = roomNumber;
        this.roomName = roomName;
        this.description = description;
        this.enemy = enemy;
    }

    public RatEnemys getEnemy() {
        return enemy;
    }

    public void displayRoom() {
        System.out.println("Room " + roomNumber + ": " + roomName);
        System.out.println(description);
    }
}
