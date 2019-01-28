package com.capgemini.molvenohotel.ReserveringsApp.search;

import com.capgemini.molvenohotel.ReserveringsApp.basics.Room;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class that checks if a room or set of rooms can provide the desired capacity
 */

public class CapacityChecker {
    int currentCapacity;
    int currentAmountOfRooms;
    private List<Room> suggestion;

    public CapacityChecker() {
        currentCapacity = 0;
        currentAmountOfRooms = 0;
        suggestion = new ArrayList<>();
    }

    public List<Room> makeSuggestionWithAmountOfRooms(List<Room> availableRooms, int amountOfGuests, int amountOfRooms) {
        // sorteer de lijst op capaciteit
        availableRooms.sort(Comparator.comparingInt(Room::getCapacity).reversed());
        if (availableRooms.size() < amountOfRooms) {
            return null;
        }
        // loop alle kamers door
        for (int i = 0; i < availableRooms.size(); i++) {
            // begin met de eerste
            Room room = availableRooms.get(i);
            // als de capaciteit + de capaciteit van deze kamer teveel is, skip deze dan
            if (currentCapacity + room.getCapacity() > amountOfGuests) {
                continue;
            }
            // anders, voeg em toe
            else {
                suggestion.add(room);
                currentCapacity += room.getCapacity();
                currentAmountOfRooms += 1;
            }
            // als we genoeg capaciteit hebben en precies het juiste aantal kamers, dan zijn we klaar
            if (currentCapacity == amountOfGuests && currentAmountOfRooms == amountOfRooms) {
                return suggestion;
            }
        }
        // als we hier zijn is het nog niet gelukt. Gooi een kamer weg.
        availableRooms.remove(suggestion.get(0));
        suggestion.clear();
        currentCapacity = 0;
        currentAmountOfRooms = 0;


        return makeSuggestionWithAmountOfRooms(availableRooms, amountOfGuests, amountOfRooms);


    }
}