package hotel;

        import basics.Room;
        import basics.RoomAttribute;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Initializes rooms for molveno
 */
public class InitializeRooms {
    private List<Room> rooms = new ArrayList<>();
    private List<RoomAttribute> allRoomAttributes = new ArrayList<>();
    public Room room1;
    public Room room2;
    public InitializeRooms() {
        allRoomAttributes.add(new RoomAttribute("Jacuzzi", "This room has a jacuzzi"));
        allRoomAttributes.add(new RoomAttribute("Child friendly", "A room which is childfriendly"));
        allRoomAttributes.add(new RoomAttribute("Balcony", "There's a balcony in this room"));

        List<RoomAttribute> room1Attributes = new ArrayList<>();
        List<RoomAttribute> room2Attributes = new ArrayList<>();
        List<RoomAttribute> room3Attributes = new ArrayList<>();

        room1Attributes.add(allRoomAttributes.get(0));
        room2Attributes.add(allRoomAttributes.get(1));
        room3Attributes.add(allRoomAttributes.get(2));

        rooms.add(new Room("101", 10.0, 50.0, 1, 0, 1, true, room1Attributes, null));
        rooms.add(new Room("102", 20.0, 100.0, 2, 0, 2, true, room2Attributes, null));
        rooms.add(new Room("103", 30.0, 150.0, 1, 2, 3, true, room3Attributes, null));
        rooms.add(new Room("104", 40.0, 200.0, 2, 2, 4, true, room3Attributes, null));
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room getOneRoom(int roomNumber) {
        return rooms.get(roomNumber);
    }
}