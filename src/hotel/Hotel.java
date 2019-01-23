package hotel;

import basics.Reservation;
import basics.Room;
import basics.RoomAttribute;
import payment.Invoice;
import search.SearchModule;
import user.Guest;

import java.time.LocalDate;
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
    private List<Guest> guests;
    private List<Invoice> invoices;
    private List<Reservation> reservations;

    private SearchModule searchModule = new SearchModule();

<<<<<<< HEAD
=======
    public Hotel(String name, String telNo, String email) {
        this.name = name;
        this.telNo = telNo;
        this.email = email;
    }

>>>>>>> FeatureInvoice
    public Hotel(String name, String telNo, String email, List<Room> rooms, List<Guest> guests
            , List<Invoice> invoices, List<Reservation> reservations) {
        this.name = name;
        this.telNo = telNo;
        this.email = email;
        this.rooms = rooms;
        this.guests = guests;
        this.invoices = invoices;
        this.reservations = reservations;
    }

    public Hotel(String name, String telNo, String email, List<Room> rooms, List<Guest> guests
            , List<Reservation> reservations) {
        this.name = name;
        this.telNo = telNo;
        this.email = email;
        this.rooms = rooms;
        this.guests = guests;
        this.reservations = reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Guest> getGuests() {
        return guests;
    }

<<<<<<< HEAD
    public void search(LocalDateTime start, LocalDateTime end, int amountOfGuests, int amountOfRooms) {
        // eerst de suggestie
        System.out.println("Eerst de suggestie:");
        List<Room> suggestion = searchModule.searchSuggestion(start, end, amountOfGuests, amountOfRooms, this);
        for (Room room : suggestion) {
            System.out.println(room.toString());
        }

        // dan de rest
        System.out.println("Dan de rest:");
        List<Room> availableRooms = searchModule.searchAll(start, end, this);
=======
    public void searchDate(LocalDateTime start, LocalDateTime end, int amountOfGuests, int amountOfRooms) {
        List<Room> availableRooms = searchModule.searchDate(start, end, amountOfGuests, amountOfRooms, this);

        System.out.println("Searching for " + amountOfRooms + " rooms available between " + start + " and " + end
                + " for " + amountOfGuests + " guests...\n");
        System.out.println(availableRooms.size() + " rooms found: \n ");
>>>>>>> FeatureInvoice
        for (Room room : availableRooms) {
            System.out.println(room.toString());
        }

    }
    public void addReservation(Reservation reservation){
        reservations.add(reservation);
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

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
