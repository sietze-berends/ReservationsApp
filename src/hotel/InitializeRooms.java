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

        List<RoomAttribute> room1Attributes = new ArrayList<>();
        List<RoomAttribute> room2Attributes = new ArrayList<>();
        room1Attributes.add(allRoomAttributes.get(0));
        room2Attributes.add(allRoomAttributes.get(1));

       room1 = new Room("101", 20.0, 100.0, 0, 1, 2, true, room1Attributes, null);
        rooms.add(room1);
       room2 = new Room("102", 40.0, 200.0, 2, 1, 4, true, room2Attributes, null);
        rooms.add(room2);
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
