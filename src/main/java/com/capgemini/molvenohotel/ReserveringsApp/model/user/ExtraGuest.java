package com.capgemini.molvenohotel.ReserveringsApp.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExtraGuest extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long extraGuestId;
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
