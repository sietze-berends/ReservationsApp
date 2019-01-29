package com.capgemini.molvenohotel.ReserveringsApp.user;

// import sun.security.util.Password;

/**
 * Admin class which has more rights than the user
 */
public class Admin extends User{

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
