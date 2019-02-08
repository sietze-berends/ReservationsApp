package com.capgemini.molvenohotel.ReserveringsApp.model.basics.user;

// import sun.security.util.Password;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Admin class which has more rights than the user
 */
@Entity
public class Admin extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long adminId;

    private String username;
    private String password;


    public Admin(String firstName, String lastName, String username, String password) {
        super(firstName, lastName);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
