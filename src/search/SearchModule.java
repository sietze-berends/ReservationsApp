package search;

import basics.Room;
import hotel.Hotel;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Search class. Calls several helper methods to check if the date is available, desired attributes are available,
 * capacity is enough, etc.
 */

public class SearchModule {
    public SearchModule() {

    }

    public ArrayList<Room> search(LocalDateTime start, LocalDateTime end, int amountOfGuests, int amountOfRooms, Hotel hotel) {
        AvailabilityChecker availabilityChecker = new AvailabilityChecker();
        ArrayList<Room> availableRooms = availabilityChecker.checkAvailability(start, end, hotel);
        return availableRooms;

    }
}