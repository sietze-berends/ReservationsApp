package com.capgemini.molvenohotel.ReserveringsApp.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Class that models a guest
 */
@Entity
public class Guest extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long guestId;

    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private String nationality;
    private int guestIdWeb;

    public int getGuestIdWeb() {
        return guestIdWeb;
    }

    public Guest(int guestIdWeb, String firstName, String lastName, LocalDate dateOfBirth, String email, String password, String nationality) {

        super(firstName, lastName);
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.nationality = nationality;
        this.guestIdWeb = guestIdWeb;
    }

    public Guest(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBookerString() {
        return getFirstName() + " " + getLastName();
    }
}