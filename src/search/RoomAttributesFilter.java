package search;

import basics.Room;
import basics.RoomAttribute;

import java.util.List;

/**
 * Class that checks if a room has desired attributes
 */

public class RoomAttributesFilter {
    public RoomAttributesFilter() {

    }

    public List<Room> filter(List<RoomAttribute> desiredAttributes, List<Room> availableRooms) {

        // check alle kamers in availableRooms
        for (Room room : availableRooms) {
            boolean matchesAttributes = true;

            // check alle gewenste attributen
            for (RoomAttribute roomAttribute : desiredAttributes) {
                if (!room.getRoomAttributes().contains(roomAttribute)) {
                    matchesAttributes = false;
                    break;
                }
            }

            // zo nee: gooi em uit de lijst
            if (!matchesAttributes) {
                availableRooms.remove(room);
            }
        }
        // geef de lijst met alle kamers die voldoen aan de wensen terug
        return availableRooms;
    }
}

