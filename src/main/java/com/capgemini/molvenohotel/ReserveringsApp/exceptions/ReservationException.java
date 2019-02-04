package com.capgemini.molvenohotel.ReserveringsApp.exceptions;

import com.capgemini.molvenohotel.ReserveringsApp.model.basics.Reservation;

public class ReservationException extends Exception {
    private final Reservation reservation;
    public ReservationException(Reservation reservation) {
        this.reservation = reservation;
    }
}
