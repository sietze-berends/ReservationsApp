package com.capgemini.molvenohotel.ReserveringsApp.model.basics;

public class InternetReservation {
    private String rooms;
    private String from;
    private String to;
    private String guests;
    private String booker;

    public InternetReservation(String rooms, String from, String to, String guests, String booker) {
        this.rooms = rooms;
        this.from = from;
        this.to = to;
        this.guests = guests;
        this.booker = booker;
    }

    public String getRooms() {
        return rooms;
    }

    public String getFrom() {
        return from;
    }

    public String getUntil() {
        return to;
    }

    public String getGuests() {
        return guests;
    }

    public String getBooker() {
        return booker;
    }
}
