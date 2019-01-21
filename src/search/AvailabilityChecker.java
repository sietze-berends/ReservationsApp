package search;

import basics.Reservation;
import basics.Room;
import hotel.Hotel;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class AvailabilityChecker {

    public AvailabilityChecker() {

    }

    public ArrayList<Room> checkAvailability(LocalDateTime start, LocalDateTime end, Hotel hotel) {
        ArrayList<Room> availableRooms = new ArrayList<>();
        for (Room room : hotel.getRooms()) {
            boolean available = false;
            if (hotel.getReservations().isEmpty()) {
                availableRooms.add(room);
                continue;
            }
            for (Reservation reservation : hotel.getReservations()) {
                if (reservation.getRoom() == room) {
                    if (reservation.getStart().isAfter(end) || reservation.getEnd().isBefore(start)) {
                        available = true;
                    } else {
                        available = false;
                        break;
                    }
                } else {
                    available = true;
                }
            }
            if (available) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}
