package com.capgemini.molvenohotel.ReserveringsApp.dto;

public class ReservationDTO {
    private String rooms;
    private String from;
    private String to;
    private String guests;
    private String booker;

    public ReservationDTO(String rooms, String from, String to, String guests, String booker) {
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
