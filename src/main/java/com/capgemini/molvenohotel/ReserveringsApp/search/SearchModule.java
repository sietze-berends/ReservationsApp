package com.capgemini.molvenohotel.ReserveringsApp.search;

import com.capgemini.molvenohotel.ReserveringsApp.model.basics.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Search class. Calls several helper methods to check if the date is available, desired attributes are available,
 * capacity is enough, etc.
 */
//@Component
public class SearchModule {
    private AvailabilityChecker availabilityChecker;
    private CapacityChecker capacityChecker;
    private AttributesChecker attributesChecker;

    public SearchModule() {
        availabilityChecker = new AvailabilityChecker();
        capacityChecker = new CapacityChecker();
        attributesChecker = new AttributesChecker();
    }

    public List<Room> searchSuggestion(LocalDateTime start, LocalDateTime end, int amountOfGuests, int amountOfRooms, Hotel hotel) {
        List<Room> suggestion = new ArrayList<>();
        suggestion = availabilityChecker.checkAvailability(start, end, hotel);
        suggestion = capacityChecker.makeSuggestionWithAmountOfRooms(suggestion, amountOfGuests, amountOfRooms);
        return suggestion;
    }
    
    public List<Room> searchAll(LocalDateTime start, LocalDateTime end, Hotel hotel) {
        List<Room> availableRooms = new ArrayList<>();
        availableRooms = availabilityChecker.checkAvailability(start, end, hotel);
        return availableRooms;
    }

//    public List<Room> searchAttributes(List<RoomAttribute> desiredAttributes, List<Room> allRooms) {
//        List<Room> filteredRooms;
//        AttributesChecker attributesChecker = new AttributesChecker();
//        filteredRooms = attributesChecker.filter(desiredAttributes, allRooms);
//        return filteredRooms;
//    }
}