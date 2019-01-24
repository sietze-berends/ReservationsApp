package search;

import basics.Room;
import basics.RoomAttribute;
import hotel.Hotel;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Search class. Calls several helper methods to check if the date is available, desired attributes are available,
 * capacity is enough, etc.
 */

public class SearchModule {
    private List<Room> suggestion;
    private List<Room> availableRooms;
    private AvailabilityChecker availabilityChecker;
    private CapacityChecker capacityChecker;
    private AttributesChecker attributesChecker;

    public SearchModule() {
        availabilityChecker = new AvailabilityChecker();
        capacityChecker = new CapacityChecker();
        attributesChecker = new AttributesChecker();
    }

    public List<Room> searchSuggestion(LocalDateTime start, LocalDateTime end, int amountOfGuests, int amountOfRooms, Hotel hotel) {
        suggestion = availabilityChecker.checkAvailability(start, end, hotel);
        suggestion = capacityChecker.makeSuggestionWithAmountOfRooms(suggestion, amountOfGuests, amountOfRooms);
        return suggestion;
    }
    
    public List<Room> searchAll(LocalDateTime start, LocalDateTime end, Hotel hotel) {
        availableRooms = availabilityChecker.checkAvailability(start, end, hotel);
        return availableRooms;
    }

    public List<Room> searchAttributes(List<RoomAttribute> desiredAttributes, List<Room> availableRooms) {
        AttributesChecker attributesChecker = new AttributesChecker();
        this.availableRooms = attributesChecker.filter(desiredAttributes, availableRooms);
        return availableRooms;
    }
}