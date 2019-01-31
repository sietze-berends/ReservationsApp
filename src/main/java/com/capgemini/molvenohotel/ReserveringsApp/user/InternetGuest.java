package com.capgemini.molvenohotel.ReserveringsApp.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class InternetGuest extends Guest {
    private static AtomicInteger counter = new AtomicInteger(1000);
    private String guestId;
    private String dateOfBirth;
    private String email;
    private String password;
    private String nationality;

    public InternetGuest(String firstName, String lastName, String dateOfBirth, String email, String password, String nationality) {
        super(firstName, lastName, LocalDate.parse(dateOfBirth,DateTimeFormatter.ofPattern("yyyy-MM-dd")), email, password, nationality);

    }
}
