package com.capgemini.molvenohotel.ReserveringsApp.model.basics.user;

import javax.persistence.MappedSuperclass;

/**
 * Superclass that models a basic user. In order of increasing permissions, this could be a:
 * Guest, receptionist, chief receptionist, operational manager or owner
 */
@MappedSuperclass
public abstract class User {

    private String firstName;
    private String lastName;

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    // creates getter and setter for Guest and Admin
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
