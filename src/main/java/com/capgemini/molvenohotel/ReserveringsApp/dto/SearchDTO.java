package com.capgemini.molvenohotel.ReserveringsApp.dto;

public class SearchDTO {
    private String start;
    private String end;
    private int amountOfPersons;
    private int amountOfRooms;

    public SearchDTO(String start, String end, int amountOfPersons, int amountOfRooms) {
        this.start = start;
        this.end = end;
        this.amountOfPersons = amountOfPersons;
        this.amountOfRooms = amountOfRooms;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public int getAmountOfPersons() {
        return amountOfPersons;
    }

    public int getAmountOfRooms() {
        return amountOfRooms;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", amountOfPersons=" + amountOfPersons +
                ", amountOfRooms=" + amountOfRooms +
                '}';
    }
}
