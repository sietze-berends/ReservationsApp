package com.capgemini.molvenohotel.ReserveringsApp.search;

public class SearchDetails {
    private String start;
    private String end;
    private int amountOfPersons;
    private int amountOfRooms;

    public SearchDetails(String start, String end, int amountOfPersons, int amountOfRooms) {
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
}
