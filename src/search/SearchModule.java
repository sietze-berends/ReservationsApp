package search;

import basics.Room;
import basics.RoomAttribute;
import hotel.Hotel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Search class. Calls several helper methods to check if the date is available, desired attributes are available,
 * capacity is enough, etc.
 */

public class SearchModule {
    private List<Room> availableRooms;
    public SearchModule() {
    }

    public List<Room> searchDate(LocalDateTime start, LocalDateTime end, int amountOfGuests, int amountOfRooms, Hotel hotel) {
        // roep eerst de datumchecker aan
        AvailabilityChecker availabilityChecker = new AvailabilityChecker();
        availableRooms = availabilityChecker.checkAvailability(start, end, hotel);
        return availableRooms;
    }

    public List<Room> searchAttributes(List<RoomAttribute> desiredAttributes, List<Room> availableRooms) {
        RoomAttributesFilter roomAttributesFilter = new RoomAttributesFilter();
        availableRooms = roomAttributesFilter.filter(desiredAttributes, availableRooms);
        return availableRooms;
    }
}