package com.capgemini.molvenohotel.ReserveringsApp.initializer;

import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Hotel;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Reservation;
import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Room;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Initializes reservations for molveno
 */
public class InitializeReservations {
    private List<Reservation> reservations = new ArrayList<>();

    public InitializeReservations(Hotel hotel) {
        Reservation reservationOne = new Reservation(hotel.getRooms().subList(0, 3),
                LocalDateTime.of(2019, 05, 5, 14, 00),
                LocalDateTime.of(2019,05,8,11,00), hotel.getGuests().get(0), hotel.getExtraGuests());

        Reservation reservationTwo = new Reservation(hotel.getRooms().subList(3, 6),
                LocalDateTime.of(2019, 06, 20, 14, 00),
                LocalDateTime.of(2019,06,24,11,00), hotel.getGuests().get(0), hotel.getExtraGuests());

        Reservation reservationThree = new Reservation(hotel.getRooms().subList(6, 9),
                LocalDateTime.of(2019, 05, 2, 14, 00),
                LocalDateTime.of(2019,05,5,11,00), hotel.getGuests().get(1), hotel.getExtraGuests());

        reservations.add(reservationOne);
        reservations.add(reservationTwo);
        reservations.add(reservationThree);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
    }