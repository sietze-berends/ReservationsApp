package search;

import basics.Room;
import hotel.Hotel;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SearchModule {
    public SearchModule() {

    }

    public ArrayList<Room> search(LocalDateTime start, LocalDateTime end, int amountOfGuests, int amountOfRooms, Hotel hotel) {
        AvailabilityChecker availabilityChecker = new AvailabilityChecker();
        ArrayList<Room> availableRooms = availabilityChecker.checkAvailability(start, end, hotel);
        return availableRooms;

    }
}