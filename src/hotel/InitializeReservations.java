package hotel;

import basics.Reservation;
import basics.Room;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class InitializeReservations {
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public InitializeReservations(Hotel hotel) {
        reservations.add(new Reservation(hotel.getRooms().get(0),
                LocalDateTime.of(2019, 01, 21, 01, 00),
                LocalDateTime.of(2019,01,24,01,00), hotel.getGuests().get(0)));
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
}
