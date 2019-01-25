package user;

import sun.security.util.Password;

/**
 * Admin class which has more rights than the user
 */
public class Admin extends User{

    private String username;
    private Password password;  // is this datatype correct?


    public Admin(String firstName, String lastName, String username, Password password) {
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

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}
