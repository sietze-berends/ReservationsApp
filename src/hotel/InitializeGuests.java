package hotel;

import user.Guest;

import java.time.LocalDate;
import java.util.ArrayList;

public class InitializeGuests {
    private ArrayList<Guest> guests = new ArrayList<>();

    public InitializeGuests() {
        guests.add(new Guest("1", "Sietze", "Berends", LocalDate.of(1993, 6,
                9), "sietze.berends@capgemini.com", "wwCapK42csd"));

        guests.add(new Guest("2", "Pim", "Groenveld", LocalDate.of(1992, 2,
                11), "pim.groeneveld@capgemini.com", "wwCapScrumMaster42"));
// test
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }
}
