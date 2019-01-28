package com.capgemini.molvenohotel.ReserveringsApp.hotel;

import com.capgemini.molvenohotel.ReserveringsApp.basics.Reservation;
import com.capgemini.molvenohotel.ReserveringsApp.basics.Room;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Initializes reservations for molveno
 */
public class InitializeReservations {
    private List<Reservation> reservations = new ArrayList<>();
    private Reservation reservation1;

    // vrij zeker dat dit niet correct werkt. Blijf nullpointer expression ontvangen via controller
    public InitializeReservations(Hotel hotel) {
        reservation1 = new Reservation(hotel.getRooms(),
                LocalDateTime.of(2019, 01, 28, 01, 00),
                LocalDateTime.of(2019,01,24,01,00), hotel.getGuests().get(0), 1);
        reservations.add(reservation1);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Reservation returnReservation1(){
        return reservation1;
    }
}