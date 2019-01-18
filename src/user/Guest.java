package user;

import java.time.LocalDate;

public class Guest extends User{
    private String guestId;
    private LocalDate dateOfBirth;
    private String email;
    private String password;

    public Guest(String guestId, String firstName, String lastName, LocalDate dateOfBirth, String email, String password) {
        super(firstName, lastName);
        this.guestId = guestId;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
    }

    public String getGuestId() {
        return guestId;
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
}