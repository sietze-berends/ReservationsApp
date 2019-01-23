package search;

import basics.Reservation;
import basics.Room;
import hotel.Hotel;

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

        // als het hotel überhaupt geen reservering heeft, dan zijn alle kamers beschikbaar
        if (hotel.getReservations().isEmpty()) {
            return hotel.getRooms();
        }

        // voor iedere kamer die het hotel heeft
        for (Room room : hotel.getRooms()) {
            boolean available = false;
            // check iedere reservering
            for (Reservation reservation : hotel.getReservations()) {
                // als de reservering over dezelfde kamer gaat
                if (reservation.getRoom() == room) {
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
