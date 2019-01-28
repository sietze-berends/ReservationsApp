package com.capgemini.molvenohotel.ReserveringsApp.user;

public class ExtraGuest extends User{

    private String nationality;

    public ExtraGuest(String firstName, String lastName, String nationality) {
        super(firstName, lastName);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
