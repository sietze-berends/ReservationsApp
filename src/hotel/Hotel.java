package hotel;

import basics.Reservation;
import basics.Room;
import payment.Invoice;
import search.SearchModule;
import user.Guest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class that models the Molveno lake resort. Hotel holds all the rooms, guests, invoices and reservations.
 * Hotel has some methods to perform searches, make bookings, etc
 */
public class Hotel {
    // TODO: make sure this is a Singleton
    private static Hotel hotel = null;

    // some basic details about the hotel.Hotel
    private String name;
    private String telNo;
    private String email;

    private List<Room> rooms;
    private ArrayList<Guest> guests;
    private ArrayList<Invoice> invoices;
    private ArrayList<Reservation> reservations;

    private SearchModule searchModule = new SearchModule();

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }



    public Hotel(String name, String telNo, String email) {
        this.name = name;
        this.telNo = telNo;
        this.email = email;
    }

    public Hotel(String name, String telNo, String email, ArrayList<Room> rooms, ArrayList<Guest> guests
            , ArrayList<Invoice> invoices, ArrayList<Reservation> reservations) {
        this.name = name;
        this.telNo = telNo;
        this.email = email;
        this.rooms = rooms;
        this.guests = guests;
        this.invoices = invoices;
        this.reservations = reservations;
    }

    public void search(LocalDateTime start, LocalDateTime end, int amountOfGuests, int amountOfRooms) {
        ArrayList<Room> availableRooms = searchModule.search(start, end, amountOfGuests, amountOfRooms, this);
        System.out.println("Searching for " + amountOfRooms + " rooms available between " + start + " and " + end
                + " for " + amountOfGuests + " guests...\n");
        System.out.println(availableRooms.size() + " rooms found: \n ");
        for (Room room : availableRooms) {
            System.out.println(room);
        }
    }

    @Override
    public String toString() {
        String output;
        output = "This hotel has the following rooms:\n";
        for (Room room : rooms) {
            output += room.toString() + "\n";
        }
        return output;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Reservation> getReservations() {
            return reservations;
    }
}
