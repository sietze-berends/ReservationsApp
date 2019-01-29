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

    // vrij zeker dat dit niet correct werkt. Blijf nullpointer expression ontvangen via controller
    public InitializeReservations(Hotel hotel) {
        Reservation reservationOne = new Reservation(hotel.getRooms(),
                LocalDateTime.of(2019, 02, 5, 14, 00),
                LocalDateTime.of(2019,02,8,11,00), hotel.getGuests().get(0), hotel.getExtraGuests(), 1);
        Reservation reservationTwo = new Reservation(hotel.getRooms(),
                LocalDateTime.of(2019, 02, 20, 14, 00),
                LocalDateTime.of(2019,02,24,11,00), hotel.getGuests().get(0), hotel.getExtraGuests(),  1);

        Reservation reservationThree = new Reservation(hotel.getRooms(),
                LocalDateTime.of(2019, 02, 2, 14, 00),
                LocalDateTime.of(2019,02,5,11,00), hotel.getGuests().get(1), hotel.getExtraGuests(), 1);


        reservations.add(reservationOne);
        reservations.add(reservationTwo);
        reservations.add(reservationThree);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
    }