package search;

import basics.Room;
import basics.RoomAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that checks if a room has desired attributes
 */

public class AttributesChecker {
    public AttributesChecker() {

    }

    public List<Room> filter(List<RoomAttribute> desiredAttributes, List<Room> allRooms) {
        List<Room> filteredRooms = new ArrayList<>();
        // check alle kamers in availableRooms
        for (Room room : allRooms) {
            // check alle gewenste attributen
            for (RoomAttribute roomAttribute : desiredAttributes) {
                System.out.println(roomAttribute);
                System.out.println(room.getRoomAttributes());
                if (room.getRoomAttributes().contains(roomAttribute)) {
                    System.out.println("Match! Room witch capacity " + room.getCapacity() + " has " + room.getRoomAttributes());
                    filteredRooms.add(room);
                }
            }
        }
        return filteredRooms;
    }
}

