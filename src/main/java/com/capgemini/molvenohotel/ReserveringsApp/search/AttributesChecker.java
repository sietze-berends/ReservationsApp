package com.capgemini.molvenohotel.ReserveringsApp.search;

import com.capgemini.molvenohotel.ReserveringsApp.basics.Room;
import com.capgemini.molvenohotel.ReserveringsApp.basics.RoomAttribute;

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
            for (RoomAttribute desiredRoomAttribute : desiredAttributes) {
                boolean contains = room.getRoomAttributes().contains(desiredRoomAttribute);
                if (room.getRoomAttributes().contains(desiredRoomAttribute)) {
                    System.out.println("Match! Room with capacity " + room.getCapacityRoom() + " has " + room.getRoomAttributes());
                    filteredRooms.add(room);
                }
            }
        }
        return filteredRooms;
    }
}

