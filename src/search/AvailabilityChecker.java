package search;

import basics.Reservation;
import basics.Room;
import hotel.Hotel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that checks if a room is available on a given date
 */
public class AvailabilityChecker {

    public AvailabilityChecker() {

    }

    public List<Room> checkAvailability(LocalDateTime start, LocalDateTime end, Hotel hotel) {
        List<Room> availableRooms = new ArrayList<>();
        // als het hotel überhaupt geen reservering heeft, dan is de kamer beschikbaar
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
                    // als de startdatum van de reservering na de einddatum van de gewenste reservering is
                    // of de einddatum van de reservering is voor de startdatum van de reservering
                    // dan is de kamer beschikbaar
                    if (reservation.getStart().isAfter(end) || reservation.getEnd().isBefore(start)) {
                        available = true;
                    }
                    // als de kamer niet beschikbaar is, stop dan met het checken van de overige reserveringen
                    // de kamer is namelijk niet beschikbaar, ongeacht de rest van de reserveringen
                    else {
                        available = false;
                        break;
                    }
                } // als de gevonden reserververing over een andere kamer gaat dan de gewenste
                else {
                    available = true;
                }
            }
            // als de kamer na het checken van alle reservering nog steeds beschikbaar is
            // voeg deze dan toe aan de beschikbare kamers
            if (available) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}
