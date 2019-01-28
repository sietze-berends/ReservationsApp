package com.capgemini.molvenohotel.ReserveringsApp.basics;

public class ReservationException extends Exception {
    private final Reservation reservation;
    public ReservationException(Reservation reservation) {
        this.reservation = reservation;
    }
}
