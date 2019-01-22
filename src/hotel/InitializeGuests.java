package hotel;

import user.Guest;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Initializes guests for molveno
 */

public class InitializeGuests {
    private ArrayList<Guest> guests = new ArrayList<>();

    public InitializeGuests() {
        guests.add(new Guest("1", "Sietze", "Berends", LocalDate.of(1993, 6,
                9), "sietze.b@gmail.com", "toEncrypt"));

        guests.add(new Guest("2", "Pim", "Groenveld", LocalDate.of(1992, 2,
                11), "pim.g@gmail.com", "toEncrypt"));

    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }
}
