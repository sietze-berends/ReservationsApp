package com.capgemini.molvenohotel.ReserveringsApp.user;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class that models a guest
 */
public class Guest extends User{
    private static AtomicInteger counter = new AtomicInteger(1000);
    private String guestId;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private String nationality;

    public Guest(String firstName, String lastName, LocalDate dateOfBirth, String email, String password, String nationality) {

        super(firstName, lastName);
        this.guestId = Integer.toString(counter.getAndIncrement());
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.nationality = nationality;
    }

    public int getGuestId() {
        return Integer.valueOf(guestId);
    }

    public void setGuestId(String guestId) {
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