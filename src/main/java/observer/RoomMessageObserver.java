package observer;

public class RoomMessageObserver implements RoomObserver {
    @Override
    public void onRoomEntered(int roomNumber) {
        System.out.println("Vad modigt av dig att våga gå in i rum nummer " + roomNumber + "!");
    }
}
