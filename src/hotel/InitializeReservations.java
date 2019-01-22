package hotel;

import basics.Reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Initializes reservations for molveno
 */
public class InitializeReservations {
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public InitializeReservations(Hotel hotel) {
        reservations.add(new Reservation(hotel.getRooms().get(0),
                LocalDateTime.of(2019, 01, 28, 01, 00),
                LocalDateTime.of(2019,01,30,01,00), hotel.getGuests().get(0)));
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
}