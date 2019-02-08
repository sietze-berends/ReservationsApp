package com.capgemini.molvenohotel.ReserveringsApp.model.basics.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//@Entity
public class InternetGuest extends Guest {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long internetGuestId;

    private String guestId;
    private String dateOfBirth;
    private String email;
    private String password;
    private String nationality;

    public InternetGuest(String firstName, String lastName, String dateOfBirth, String email, String password, String nationality) {
        super(firstName, lastName, LocalDate.parse(dateOfBirth,DateTimeFormatter.ofPattern("yyyy-MM-dd")), email, password, nationality);

    }

    public long getInternetGuestId() {
        return internetGuestId;
    }
}
