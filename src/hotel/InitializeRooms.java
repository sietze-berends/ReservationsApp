package hotel;

import basics.Room;
import basics.RoomAttribute;

import java.util.ArrayList;

/**
 * Initializes rooms for molveno
 */
public class InitializeRooms {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<RoomAttribute> allRoomAttributes = new ArrayList<>();

    public InitializeRooms() {
        allRoomAttributes.add(new RoomAttribute("Jacuzzi", "This room has a jacuzzi"));
        allRoomAttributes.add(new RoomAttribute("Child friendly", "A room which is childfriendly"));

        ArrayList<RoomAttribute> room1Attributes = new ArrayList<>();
        ArrayList<RoomAttribute> room2Attributes = new ArrayList<>();
        room1Attributes.add(allRoomAttributes.get(0));
        room2Attributes.add(allRoomAttributes.get(1));

        rooms.add(new Room("101", 20.0, 100.0, 0, 1, 2, true, room1Attributes, null));
        rooms.add(new Room("102", 40.0, 200.0, 2, 1, 4, true, room2Attributes, null));
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
