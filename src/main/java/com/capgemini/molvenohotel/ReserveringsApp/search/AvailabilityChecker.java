package com.capgemini.molvenohotel.ReserveringsApp.search;

import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Hotel;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class that checks if a room is available on a given date
 */
public class AvailabilityChecker {


    public AvailabilityChecker() {
    }

    public List<Room> checkAvailability(LocalDateTime start, LocalDateTime end, Hotel hotel) {
        List <Room> availableRooms = new ArrayList<>();

        // als het rooms überhaupt geen reservering heeft, dan zijn alle kamers beschikbaar
        if (hotel.getReservations().isEmpty()) {
            return hotel.getRooms();
        }

        // voor iedere kamer die het rooms heeft
        for (Room room : hotel.getRooms()) {
            boolean available = false;
            // check iedere reservering
            for (Reservation reservation : hotel.getReservations()) {
                // als de reservering over dezelfde kamer gaat
                if (reservation.getRooms() == room) {
                    // startdatum van de reservering na de einddatum van de gewenste reservering
                    // of einddatum van de reservering voor de startdatum van de gewenste reservering
                    if (reservation.getStart().isAfter(end) || reservation.getEnd().isBefore(start)) {
                        available = true;
                    }
                    // als kamer niet beschikbaar is, stop met het checken van de overige reserveringen
                    else {
                        available = false;
                        break;
                    }
                } // als reserververing over een andere kamer gaat
                else {
                    available = true;
                }
            }

            // als de kamer na het checken van alle reserveringen nog steeds beschikbaar is voeg deze dan toe
            if (available) {
                availableRooms.add(room);
            }
        }
        availableRooms.sort(Comparator.comparingDouble(Room::getPrice).reversed());
        return availableRooms;
    }
}
