package RattWorld;

public class Room {

    private int roomNumber;
    private String roomName;
    private String description;

    // Constructor
    public Room(int roomNumber, String roomName, String description) {
        this.roomNumber = roomNumber;
        this.roomName = roomName;
        this.description = description;
    }

    // Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getDescription() {
        return description;
    }

    // Display room information
    public void displayRoom() {
        System.out.println("Room " + roomNumber + ": " + roomName);
        System.out.println(description);
    }
}