package observer;

public class RoomVisitObserver implements RoomObserver {

    private int visitedRooms = 0;

    @Override
    public void onRoomEntered(int roomNumber) {
        visitedRooms++;
        System.out.println("Du har nu gått vidare till ett nytt rum " + visitedRooms + " gånger.");
    }
}
